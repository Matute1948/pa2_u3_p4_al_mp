package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "matricula")
@Entity 
public class Matricula {
    @GeneratedValue(generator = "seq_matricula",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
    @Id
    @Column(name = "matri_id")
    private Integer id;
    @Column(name = "matri_numero")
    private String numero;
    @Column(name = "matri_fecha")
    private LocalDate fecha;
    @Column(name = "matri_repetida")
    private Boolean repetida;

    @ManyToOne
    @JoinColumn(name = "matri_id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "matri_id_materia")
    private Materia materia;

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Boolean getRepetida() {
        return repetida;
    }

    public void setRepetida(Boolean repetida) {
        this.repetida = repetida;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    

    @Override
    public String toString() {
        return "Matricula [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", repetida=" + repetida + "]";
    }

    
    

}
