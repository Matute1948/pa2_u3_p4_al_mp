package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "semestre")
@Entity
public class Semestre {
    @GeneratedValue(generator = "seq_semestre", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_semestre", sequenceName = "seq_semestre",allocationSize = 1)
    @Id
    @Column(name = "stre_id")
    private Integer id;
    @Column(name = "stre_numero")
    private String numero;
    @Column(name = "stre_fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "stre_fecha_fin")
    private LocalDate fechaFin;
    @OneToMany(mappedBy = "semestre")
    private List<Materia> materia;
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
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    public List<Materia> getMateria() {
        return materia;
    }
    public void setMateria(List<Materia> materia) {
        this.materia = materia;
    }
    
    @Override
    public String toString() {
        return "Semestre [id=" + id + ", numero=" + numero + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
                + "]";
    }
    

    
    
}
