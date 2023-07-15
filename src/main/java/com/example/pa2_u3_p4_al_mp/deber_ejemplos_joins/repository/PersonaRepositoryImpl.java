package com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository.modelo.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PersonaRepositoryImpl implements IPersonaRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Persona persona) {
        this.entityManager.persist(persona);
    }

    @Override
    public void actulizar(Persona persona) {
        this.entityManager.merge(persona);
    }

    @Override
    public void eliminar(String id) {
        Persona auto = this.seleccionarPorId(id);
        this.entityManager.remove(auto);
    }

    @Override
    public Persona seleccionarPorId(String id) {
        return this.entityManager.find(Persona.class, id);
    }

    @Override
    public List<Persona> seleccionarInnerJoin() {
        String jpql = "SELECT p FROM Persona p LEFT JOIN p.automovil a";
        TypedQuery<Persona> myQuery = this.entityManager.createQuery(jpql, Persona.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Persona> seleccionarRightJoin() {
        String jpql = "SELECT p FROM Persona p RIGHT JOIN p.automovil a";
        TypedQuery<Persona> myQuery = this.entityManager.createQuery(jpql, Persona.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Persona> seleccionarFullJoin() {
        String jpql = "SELECT p FROM Persona p FULL JOIN p.automovil a";
        TypedQuery<Persona> myQuery = this.entityManager.createQuery(jpql, Persona.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Persona> seleccionarWhereJoin() {
        String jpql = "SELECT p FROM Persona p, Automovil a WHERE p = a.persona";

        TypedQuery<Persona> myQuery = this.entityManager.createQuery(jpql,Persona.class);
        return myQuery.getResultList();
    }
}
