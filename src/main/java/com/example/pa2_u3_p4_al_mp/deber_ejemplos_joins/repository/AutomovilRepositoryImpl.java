package com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository.modelo.Automovil;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutomovilRepositoryImpl implements IAutomovilRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Automovil automovil) {
        this.entityManager.persist(automovil);
    }

    @Override
    public void actulizar(Automovil automovil) {
        this.entityManager.merge(automovil);
    }

    @Override
    public void eliminar(String id) {
        Automovil auto = this.seleccionarPorId(id);
        this.entityManager.remove(auto);
    }

    @Override
    public Automovil seleccionarPorId(String id) {
        return this.entityManager.find(Automovil.class, id);
    }
    @Override
    public List<Automovil> seleccionarInnerJoin() {
        String jpql = "SELECT a FROM Automovil a LEFT JOIN a.persona p";
        TypedQuery<Automovil> myQuery = this.entityManager.createQuery(jpql, Automovil.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Automovil> seleccionarRightJoin() {
        String jpql = "SELECT a FROM Automovil a RIGHT JOIN a.persona p";
        TypedQuery<Automovil> myQuery = this.entityManager.createQuery(jpql, Automovil.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Automovil> seleccionarFullJoin() {
        String jpql = "SELECT a FROM Automovil a FULL JOIN a.persona p";
        TypedQuery<Automovil> myQuery = this.entityManager.createQuery(jpql, Automovil.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Automovil> seleccionarWhereJoin() {
        String jpql = "SELECT a FROM Automovil a, Persona p WHERE a = p.automovil";

        TypedQuery<Automovil> myQuery = this.entityManager.createQuery(jpql,Automovil.class);
        return myQuery.getResultList();
    }
    
}
