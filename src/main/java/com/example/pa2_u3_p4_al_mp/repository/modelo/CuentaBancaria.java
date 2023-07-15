package com.example.pa2_u3_p4_al_mp.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {
    @GeneratedValue(generator = "seq_cuenta_bancaria", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_cuenta_bancaria", sequenceName = "seq_cuenta_bancaria",allocationSize = 1)
    @Id
    @Column(name ="cta_id")
    private Integer id;
    @Column(name = "cta_numero")
    private String numero;
    @Column(name = "cta_saldo")
    private BigDecimal saldo;
    
        
}
