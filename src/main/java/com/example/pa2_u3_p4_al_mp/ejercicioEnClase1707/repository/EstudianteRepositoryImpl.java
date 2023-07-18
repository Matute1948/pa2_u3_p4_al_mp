package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository;

import org.springframework.stereotype.Repository;

import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }

    @Override
    public Estudiante seleccionarPorCedula(String cedula) {
        TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :datoCedula", Estudiante.class);
        myQuery.setParameter("datoCedula", cedula);
        return myQuery.getSingleResult();
    }
    
}
