package com.example.pa2_u3_p4_al_mp.tarea12_banco.repository;

import org.springframework.stereotype.Repository;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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

    @Override
    public CuentaBancaria seleccionarPorNumerp(String numCta) {
        String jpql = "SELECT c FROM CuentaBancaria c WHERE c.numero = :datoNumero";
        TypedQuery<CuentaBancaria> myQuery = this.entityManager.createQuery(jpql, CuentaBancaria.class);
        myQuery.setParameter("datoNumero", numCta);
        return myQuery.getSingleResult();
    }
    
}
