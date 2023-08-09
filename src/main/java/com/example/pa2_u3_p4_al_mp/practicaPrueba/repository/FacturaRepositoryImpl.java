package com.example.pa2_u3_p4_al_mp.practicaPrueba.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Carro;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Cliente;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional(value = TxType.MANDATORY)
    public void insertar(Factura factura) {
        this.entityManager.persist(factura);
    }

    @Override
    @Transactional(value = TxType.MANDATORY)
    public void eliminar(Integer id) {
        Factura factura = this.seleccionarPorId(id);
        this.entityManager.remove(factura);
    }

    @Override
    @Transactional(value = TxType.MANDATORY)
    public void actualizar(Factura factura) {
        this.entityManager.merge(factura);
    }

    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public Factura seleccionarPorId(Integer id) {
        return this.entityManager.find(Factura.class, id);
    }

    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public List<Factura> seleccinarPorFecha(LocalDate fecha) {
        String jpql = "SELECT f FROM Factura f WHERE f.fechaVenta <=:datoFecha";
        TypedQuery<Factura> mQuery = this.entityManager.createQuery(jpql, Factura.class);
        mQuery.setParameter("datoFecha", fecha);
        return mQuery.getResultList();
    }

    @Override
    public List<Factura> seleccionarTodo() {
        String jpql = "SELECT f FROM Factura f JOIN FETCH f.cliente c";
        TypedQuery<Factura> mQuery = this.entityManager.createQuery(jpql, Factura.class);
        return mQuery.getResultList();
    }

    @Override
    public List<Cliente> seleccionarLeft() {
        String jpql = "SELECT c FROM Factura f LEFT JOIN f.cliente c";
        TypedQuery<Cliente> mQuery = this.entityManager.createQuery(jpql, Cliente.class);
        return mQuery.getResultList();
    }

    @Override
    public List<Carro> seleccionarRight() {
        String jpql = "SELECT a FROM Factura f RIGHT JOIN f.carro a";
        TypedQuery<Carro> mQuery = this.entityManager.createQuery(jpql, Carro.class);
        return mQuery.getResultList();
    }
}
