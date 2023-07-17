package com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "propietario")
@Entity
public class Propietario {
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
    @OneToMany(mappedBy = "propietario")
    private List<CuentaBancaria> cuentasBancarias;
    // get y set
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
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public List<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }
    public void setCuentasBancarias(List<CuentaBancaria> cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }
    //toString
    @Override
    public String toString() {
        return "Proietario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + "]";
    }

    
    
}
