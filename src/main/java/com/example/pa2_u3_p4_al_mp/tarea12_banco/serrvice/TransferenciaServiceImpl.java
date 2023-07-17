package com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.ITransferenciaRepository;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{
    @Autowired
    private ITransferenciaRepository transferenciaRepository;

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
    public void procesoTransferencia(String numCtaOrigen, String numCtaDestino, BigDecimal monto) {
        this.transferenciaRepository.realizarTransferencia(numCtaOrigen, numCtaDestino, monto);
    }

    @Override
    public List<Transferencia> reporteTodoTransferencias() {
        return this.transferenciaRepository.seleccionarTodo();
    }
    
}
