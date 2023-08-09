package com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @Column(name = "cta_tipo")
    private String tipo;
    @OneToMany(mappedBy = "ctaOrigen" )
    private List<Transferencia> transferencias;
    @ManyToOne
    @JoinColumn(name = "cta_id_propietario")
    private Propietario propietario;
    

    //SET y GET
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public BigDecimal getSaldo() {
        return saldo;
    }
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Propietario getPropietario() {
        return propietario;
    }
    public void setPropietario(Propietario proietario) {
        this.propietario = proietario;
    }
    public List<Transferencia> getTransferencias() {
        return transferencias;
    }
    public void setTransferencias(List<Transferencia> cuentasOrigen) {
        this.transferencias = cuentasOrigen;
    }
    
    //toString
    @Override
    public String toString() {
        return "CuentaBancaria [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo + "]";
    }

    
    
        
}
