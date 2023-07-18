package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository;

import org.springframework.stereotype.Repository;

import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Materia materia) {
        this.entityManager.persist(materia);
    }

    @Override
    public Materia seleccionarPorCodigo(String codigo) {
        TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT e FROM Materia e WHERE e.codigo = :datoCodigo", Materia.class);
        myQuery.setParameter("datoCodigo", codigo);
        return myQuery.getSingleResult();
    }
}
