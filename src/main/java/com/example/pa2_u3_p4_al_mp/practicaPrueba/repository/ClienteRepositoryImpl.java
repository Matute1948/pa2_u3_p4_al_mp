package com.example.pa2_u3_p4_al_mp.practicaPrueba.repository;

import org.springframework.stereotype.Repository;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional(value = TxType.MANDATORY)
    public void insertar(Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Cliente seleccionarPorCedula(String cedula) {
        String jpql = "SELECT c FROM Cliente c WHERE c.cedula =:datoCedula";
        TypedQuery<Cliente> mQuery = this.entityManager.createQuery(jpql, Cliente.class);
        mQuery.setParameter("datoCedula", cedula);
        return mQuery.getSingleResult();
    }
    
}
