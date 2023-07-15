package com.example.pa2_u3_p4_al_mp.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "propietario")
@Entity
public class Proietario {
    @GeneratedValue(generator = "seq_propietario", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_propietario", sequenceName = "seq_propietario",allocationSize = 1)
    @Id
    @Column(name = "pro_id")
    private Integer id;
    @Column(name = "pro_nombre")
    private String nombre;
    @Column(name = "pro_apellido")
    private String apellido;
    @Column(name = "pro_cedula")
    private String cedula;
    
}
