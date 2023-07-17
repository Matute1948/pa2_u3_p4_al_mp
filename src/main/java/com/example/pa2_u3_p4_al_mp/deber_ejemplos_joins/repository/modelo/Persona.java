package com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "persona")
@Entity
public class Persona {
    @GeneratedValue(generator = "seq_persona", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_persona", sequenceName = "seq_persona",allocationSize = 1)
    @Id
    @Column(name = "per_id")
    private Integer id;
    @Column(name = "per_nombre")
    private String nombre;
    @Column(name = "per_apellido")
    private String apellido;
    @Column(name = "per_fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "per_edad")
    private String edad;
    @Column(name = "per_ingresos")
    private BigDecimal ingresos;
    @OneToMany(mappedBy = "persona",fetch = FetchType.LAZY)
    private List<Automovil> automovil;


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
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public BigDecimal getIngresos() {
        return ingresos;
    }
    public void setIngresos(BigDecimal ingresos) {
        this.ingresos = ingresos;
    }
    public List<Automovil> getAutomovil() {
        return automovil;
    }
    public void setAutomoviles(List<Automovil> automovil) {
        this.automovil = automovil;
    }
    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
                + fechaNacimiento + ", edad=" + edad + ", ingresos=" + ingresos + "]";
    }
}
