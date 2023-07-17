package com.example.pa2_u3_p4_al_mp.tarea12_banco.repository;

import org.springframework.stereotype.Repository;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Propietario propietario) {
        this.entityManager.persist(propietario);
    }

    @Override
    public void actulizar(Propietario propietario) {
        this.entityManager.merge(propietario);
    }

    @Override
    public void eliminar(String id) {
        Propietario prop = this.seleccionarPorId(id);
        this.entityManager.remove(prop);
    }

    @Override
    public Propietario seleccionarPorId(String id) {
        return this.entityManager.find(Propietario.class, id);
    }
    
}
