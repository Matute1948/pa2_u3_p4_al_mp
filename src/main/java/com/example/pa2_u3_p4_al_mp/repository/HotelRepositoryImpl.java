package com.example.pa2_u3_p4_al_mp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pa2_u3_p4_al_mp.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Hotel> seleccionarInnerJoin() {
        //utilizaremos el typed query
        //SELECT * FROM hotel h JOIN habitacion ha ON h.hot_id = ha.hab_id_hotel
        //relacion que hace referencia a las habitaciones 
        String jpql = "SELECT h FROM Hotel h JOIN h.habitacion ha";
        TypedQuery<Hotel> myQuery = this.entityManager.createQuery(jpql, null);
        return myQuery.getResultList();
    }

    
}
