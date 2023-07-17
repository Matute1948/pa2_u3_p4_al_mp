package com.example.pa2_u3_p4_al_mp.tarea12_banco.repository;

import org.springframework.stereotype.Repository;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(CuentaBancaria cuentaBancaria) {
        this.entityManager.persist(cuentaBancaria);
    }

    @Override
    public void actulizar(CuentaBancaria cuentaBancaria) {
        this.entityManager.merge(cuentaBancaria);
    }

    @Override
    public void eliminar(String id) {
        CuentaBancaria cuentaBancaria = this.seleccionarPorId(id);
        this.entityManager.remove(cuentaBancaria);
    }

    @Override
    public CuentaBancaria seleccionarPorId(String id) {
        return this.entityManager.find(CuentaBancaria.class, id);
    }
    
}
