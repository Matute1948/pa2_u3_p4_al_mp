package com.example.pa2_u3_p4_al_mp.tarea12_banco.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pa2_u3_p4_al_mp.repository.modelo.Hotel;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.CuentaBancaria;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Transferencia transferencia) {
        this.entityManager.persist(transferencia);
    }

    @Override
    public void actulizar(Transferencia transferencia) {
        this.entityManager.merge(transferencia);
    }

    @Override
    public void eliminar(String id) {
        Transferencia trans = this.seleccionarPorId(id);
        this.entityManager.remove(trans);
    }

    @Override
    public Transferencia seleccionarPorId(String id) {
        return this.entityManager.find(Transferencia.class, id);
    }

    @Override
    public void realizarTransferencia(String numCtaOrigen, String numCtaDestino, BigDecimal monto) {
        
    }

    @Override
    public List<Transferencia> seleccionarTodo() {
        String jpql = "SELECT f FROM Transferencia f JOIN FETCH f.ctaOrigen c";
        TypedQuery<Transferencia> myQuery = this.entityManager.createQuery(jpql, Transferencia.class);
        return myQuery.getResultList();
    }
    
}
