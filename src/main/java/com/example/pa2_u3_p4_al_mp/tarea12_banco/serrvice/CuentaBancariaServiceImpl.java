package com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.ICuentaBancariaRepository;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{
    @Autowired
    private ICuentaBancariaRepository cuentaBancariaRepository;

    private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);
    @Override
    public void agregar(CuentaBancaria cuentaBancaria) {
        LOG.info("hilo service: "+Thread.currentThread().getName());
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(Exception e){

        }
        this.cuentaBancariaRepository.insertar(cuentaBancaria);
    }
    @Override
    public String agregar2(CuentaBancaria cuentaBancaria) {
        LOG.info("hilo service: "+Thread.currentThread().getName());
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(Exception e){

        }
        this.cuentaBancariaRepository.insertar(cuentaBancaria);
        return cuentaBancaria.getNumero();
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
        return this.cuentaBancariaRepository.seleccionarPorNumero(id);
    }

    
    
}
