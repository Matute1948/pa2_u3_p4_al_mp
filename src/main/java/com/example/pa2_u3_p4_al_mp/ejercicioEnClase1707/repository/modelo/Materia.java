package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo;

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

@Table(name = "materia")
@Entity
public class Materia {
    @GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia",allocationSize = 1)
    @Id
    @Column(name = "mat_id")
    private Integer id;
    @Column(name = "mat_nombre")
    private String nombre;
    @Column(name = "mat_costo")
    private BigDecimal costo;
    @Column(name = "mat_codigo")
    private String codigo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mat_id_semestre")
    private Semestre semestre;
    @OneToMany(mappedBy = "materia")
    private List<Matricula> matriculas;
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
    public BigDecimal getCosto() {
        return costo;
    }
    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public Semestre getSemestre() {
        return semestre;
    }
    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
    public List<Matricula> getMatriculas() {
        return matriculas;
    }
    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
    @Override
    public String toString() {
        return "Materia [id=" + id + ", nombre=" + nombre + ", costo=" + costo + ", codigo=" + codigo + ", semestre="
                + semestre + "]";
    }
    

    

    
}
