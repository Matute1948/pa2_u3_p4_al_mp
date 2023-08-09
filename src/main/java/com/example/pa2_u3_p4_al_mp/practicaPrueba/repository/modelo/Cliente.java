package com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "cliente")
@Entity
public class Cliente {
    @GeneratedValue(generator = "seq_cliente", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente",allocationSize = 1)
    @Id
    @Column(name ="clie_id")
    private Integer id;
    @Column(name ="clie_nombre")
    private String nombre;
    @Column(name = "clie_cedula")
    private String cedula;
    @Column(name = "clie_salario")
    private BigDecimal salario;
    @OneToMany(mappedBy = "cliente")
    private List<Factura> listFactura;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public BigDecimal getSalario() {
        return salario;
    }
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    public List<Factura> getListFactura() {
        return listFactura;
    }
    public void setListFactura(List<Factura> listFactura) {
        this.listFactura = listFactura;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + ", cedula=" + cedula + ", salario=" + salario + "]";
    }
    

    


    
}
