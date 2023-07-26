package com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.ICuentaBancariaRepository;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.ITransferenciaRepository;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.CuentaBancaria;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.Transferencia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{
    @Autowired
    private ITransferenciaRepository transferenciaRepository;
    @Autowired
    private ICuentaBancariaRepository cuentaBancariaRepository;

    @Override
    public void agregar(Transferencia transferencia) {
        this.transferenciaRepository.insertar(transferencia);
    }

    @Override
    public void actulizar(Transferencia transferencia) {
        this.transferenciaRepository.actulizar(transferencia);
    }

    @Override
    public void remover(String id) {
        this.transferenciaRepository.eliminar(id);
    }

    @Override
    public Transferencia buscarPorId(String id) {
        return this.transferenciaRepository.seleccionarPorId(id);
    }

    @Override
    @Transactional(value = TxType.REQUIRES_NEW)
    public void procesoTransferencia(String numCtaOrigen, String numCtaDestino, BigDecimal monto) {
        CuentaBancaria cuentaBanOrigen = this.cuentaBancariaRepository.seleccionarPorNumero(numCtaOrigen);
        CuentaBancaria cuentaBanDestino = this.cuentaBancariaRepository.seleccionarPorNumero(numCtaDestino);

        //if (monto.compareTo(cuentaBanOrigen.getSaldo()) <= 0){
            cuentaBanDestino.setSaldo(monto.add(cuentaBanDestino.getSaldo()));
            cuentaBanOrigen.setSaldo(cuentaBanOrigen.getSaldo().subtract(monto));

            this.cuentaBancariaRepository.actulizar(cuentaBanDestino);
            this.cuentaBancariaRepository.actulizar(cuentaBanOrigen);
            Transferencia transferencia = new Transferencia();
            transferencia.setMonto(monto);
            transferencia.setCtaDestino(cuentaBanDestino);
            transferencia.setCtaOrigen(cuentaBanOrigen);
            transferencia.setFecha(LocalDate.of(2023, 7, 10));
            this.agregar(transferencia);

            if (cuentaBanOrigen.getSaldo().doubleValue() < 0){
                throw new RuntimeException();

            }else{
                System.out.println("PAsooo");
            }

            throw new RuntimeException();
        //}else{
        //System.out.println("Saldo insuficiente para hacer la transferencia");
        //}
        
    }

    @Override
    public List<Transferencia> reporteTodoTransferencias() {
        return this.transferenciaRepository.seleccionarTodo();
    }
    
}
