package com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "automovil")
@Entity
public class Automovil {
    @GeneratedValue(generator = "seq_automovil", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_automovil", sequenceName = "seq_automovil",allocationSize = 1)
    @Id
    @Column(name = "auto_id")
    private Integer id;
    @Column(name = "auto_placa")
    private String placa;
    @Column(name = "auto_marca")
    private String marca;
    @Column(name = "auto_valor")
    private BigDecimal valor;
    @Column(name = "auto_seguro")
    private Boolean seguro;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "auto_id_persona")
    private Persona persona;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Boolean getSeguro() {
        return seguro;
    }

    public void setSeguro(Boolean seguro) {
        this.seguro = seguro;
    }
    
     public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    @Override
    public String toString() {
        return "Automovil [id=" + id + ", placa=" + placa + ", marca=" + marca + ", valor=" + valor + ", seguro="
                + seguro + "]";
    }

   

    
    
    

    
}
