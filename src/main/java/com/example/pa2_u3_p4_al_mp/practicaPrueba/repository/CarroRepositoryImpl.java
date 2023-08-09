package com.example.pa2_u3_p4_al_mp.practicaPrueba.repository;

import org.springframework.stereotype.Repository;

import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Carro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class CarroRepositoryImpl  implements ICarroRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional(value = TxType.MANDATORY)
    public void insertar(Carro carro) {
        this.entityManager.persist(carro);
    }
    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Carro seleccionarPorPlaca(String placa) {
        String jpql = "SELECT c FROM Carro c WHERE c.placa =:datoPlaca";
        TypedQuery<Carro> mQuery = this.entityManager.createQuery(jpql, Carro.class);
        mQuery.setParameter("datoPlaca", placa);
        return mQuery.getSingleResult();
    }
    
}
