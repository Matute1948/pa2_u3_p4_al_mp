package com.example.pa2_u3_p4_al_mp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pa2_u3_p4_al_mp.repository.modelo.Habitacion;
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
        String jpql = "SELECT h FROM Hotel h LEFT JOIN h.habitacion ha";
        TypedQuery<Hotel> myQuery = this.entityManager.createQuery(jpql, Hotel.class);
        List<Hotel> lisHot = myQuery.getResultList();
        for (Hotel hotel : lisHot) {
            hotel.getHabitacion().size();
        }
        return myQuery.getResultList();
    }

    @Override
    public List<Hotel> seleccionarRightJoin() {
        String jpql = "SELECT h FROM Hotel h RIGHT JOIN h.habitacion ha";

        TypedQuery<Hotel> myQuery = this.entityManager.createQuery(jpql,Hotel.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Habitacion> seleccionarHabitacionesOuterLeftJoin() {
        String jpql = "SELECT ha FROM Hotel h LEFT JOIN h.habitacion ha";
        TypedQuery<Habitacion> myQuery = this.entityManager.createQuery(jpql,Habitacion.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Hotel> seleccionarFullJoin() {
        String jpql = "SELECT h FROM Hotel h FULL JOIN h.habitacion ha";

        TypedQuery<Hotel> myQuery = this.entityManager.createQuery(jpql,Hotel.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Hotel> seleccionarWhereJoin() {
        //SELECT h.* FROM hotel h, habitacion ha WHERE h.hot_id = ha.hab_id_hotel
        //SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel
        String jpql = "SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel";

        TypedQuery<Hotel> myQuery = this.entityManager.createQuery(jpql,Hotel.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Hotel> seleccionarFetchJoin() {
        String jpql = "SELECT h FROM Hotel h JOIN FETCH h.habitacion ha"; //ojo donde esta el fetch va despues del join
        TypedQuery<Hotel> myQuery = this.entityManager.createQuery(jpql,Hotel.class);
        return myQuery.getResultList();
    }

    @Override
    public void insertar(Hotel hotel) {
        this.entityManager.persist(hotel);
    }

    
}
