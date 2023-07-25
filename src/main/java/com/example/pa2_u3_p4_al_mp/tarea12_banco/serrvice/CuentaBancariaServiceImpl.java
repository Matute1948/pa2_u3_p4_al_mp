package com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.ICuentaBancariaRepository;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{
    @Autowired
    private ICuentaBancariaRepository cuentaBancariaRepository;
    @Override
    public void agregar(CuentaBancaria cuentaBancaria) {
        
        this.cuentaBancariaRepository.insertar(cuentaBancaria);
    }

    @Override
    public void actulizar(CuentaBancaria cuentaBancaria) {
        this.cuentaBancariaRepository.actulizar(cuentaBancaria);
    }

    @Override
    public void remover(String id) {
        this.cuentaBancariaRepository.eliminar(id);
    }

    @Override
    public CuentaBancaria buscarPorId(String id) {
        return this.cuentaBancariaRepository.seleccionarPorId(id);
    }

    @Override
    public CuentaBancaria buscarPorNumCuentaBancaria(String id) {
        return this.cuentaBancariaRepository.seleccionarPorNumerp(id);
    }
    
}
