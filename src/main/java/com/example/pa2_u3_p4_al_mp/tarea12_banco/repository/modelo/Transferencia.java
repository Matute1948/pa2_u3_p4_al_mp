package com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "transferencia")
@Entity
public class Transferencia {

    @GeneratedValue(generator = "seq_transferencia", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_transferencia", sequenceName = "seq_transferencia",allocationSize = 1)
    @Id
    @Column(name = "tf_id")
    private Integer id;
    @Column(name = "tf_fecha")
    private LocalDate fecha;
    @Column(name = "tf_monto")
    private BigDecimal monto;
    @ManyToOne
    @JoinColumn(name = "tf_id_ctaOrigen")
    private CuentaBancaria ctaOrigen;

    //set y get
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public BigDecimal getMonto() {
        return monto;
    }
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    public CuentaBancaria getCtaOrigen() {
        return ctaOrigen;
    }
    public void setCtaOrigen(CuentaBancaria ctaOrigen) {
        this.ctaOrigen = ctaOrigen;
    }
    
    //toString
    @Override
    public String toString() {
        return "Transferencia [id=" + id + ", fecha=" + fecha + ", monto=" + monto + "]";
    }

    

    

    
}
