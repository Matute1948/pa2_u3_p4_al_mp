package com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PruebaServiceImpl implements IPruebaService{

    @Override
    @Transactional(value = TxType.NEVER)
    public void prueba() {
        System.out.println("Never"+TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Metodo prueba");
    }

    @Override
    @Transactional(value = TxType.MANDATORY)
    public void prueba2() {
        System.out.println("mandatory"+TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Metodo prueba2");
    }

    @Override
    @Transactional(value = TxType.SUPPORTS)
    public void pruebaSupports() {
        System.out.println("supports"+TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Metodo supports");
    }

    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public void pruebaNotSupported() {
        System.out.println("not supported"+TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Metodo not supported");
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public void pruebaRequired() {
        System.out.println("required"+TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Metodo required");
    }

    @Override
    @Transactional(value = TxType.REQUIRES_NEW)
    public void pruebaRequiredNew() {
        System.out.println("requiredNew"+TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("Metodo requiredNew");
    }
    
}
