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
        String jpql = "SELECT c FROM CuentaBancaria c WHERE c.numero = :datoNumero";
        TypedQuery<CuentaBancaria> myQuery = this.entityManager.createQuery(jpql, CuentaBancaria.class);
        myQuery.setParameter("datoNumero", numCtaOrigen);
        CuentaBancaria cuentaBanOrigen = myQuery.getSingleResult();

        String jpql1 = "SELECT c FROM CuentaBancaria c WHERE c.numero = :datoNumero";
        TypedQuery<CuentaBancaria> myQuery1 = this.entityManager.createQuery(jpql1, CuentaBancaria.class);
        myQuery1.setParameter("datoNumero", numCtaDestino);
        CuentaBancaria cuentaBanDestino = myQuery1.getSingleResult();

        if (monto.compareTo(cuentaBanOrigen.getSaldo()) <= 0){
            cuentaBanDestino.setSaldo(monto.add(cuentaBanDestino.getSaldo()));
            cuentaBanOrigen.setSaldo(cuentaBanOrigen.getSaldo().subtract(monto));
        }else{
            System.out.println("Saldo insuficiente para hacer la transferencia");
        }

        Transferencia transferencia = new Transferencia();
        transferencia.setMonto(monto);
        transferencia.setCtaDestino(cuentaBanDestino);
        transferencia.setCtaOrigen(cuentaBanOrigen);
        transferencia.setFecha(LocalDate.of(2023, 7, 10));
        this.insertar(transferencia);
        
    }

    @Override
    public List<Transferencia> seleccionarTodo() {
        String jpql = "SELECT f FROM Transferencia f JOIN FETCH f.ctaOrigen c";
        TypedQuery<Transferencia> myQuery = this.entityManager.createQuery(jpql, Transferencia.class);
        return myQuery.getResultList();
    }
    
}
