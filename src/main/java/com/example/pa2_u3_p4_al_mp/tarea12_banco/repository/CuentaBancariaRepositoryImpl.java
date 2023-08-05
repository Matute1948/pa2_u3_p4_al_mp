package com.example.pa2_u3_p4_al_mp.tarea12_banco.repository;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.CuentaBancaria;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice.PropietarioServiceImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository{
    @PersistenceContext
    private EntityManager entityManager;
    private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaRepositoryImpl.class);
    @Override
    public void insertar(CuentaBancaria cuentaBancaria) {
        LOG.info("hilo repo: "+Thread.currentThread().getName());
        this.entityManager.persist(cuentaBancaria);
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
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
    public CuentaBancaria seleccionarPorNumero(String numCta) {
        String jpql = "SELECT c FROM CuentaBancaria c WHERE c.numero = :datoNumero";
        TypedQuery<CuentaBancaria> myQuery = this.entityManager.createQuery(jpql, CuentaBancaria.class);
        myQuery.setParameter("datoNumero", numCta);
        return myQuery.getSingleResult();
    }
    
}
