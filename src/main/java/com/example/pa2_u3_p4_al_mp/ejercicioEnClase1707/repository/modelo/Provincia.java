package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "provincia")
@Entity
public class Provincia {
    @GeneratedValue(generator = "seq_provincia", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_provincia", sequenceName = "seq_provincia",allocationSize = 1)
    @Id
    @Column(name = "pvc_id")
    private Integer id;
    @Column(name = "pvc_nombre")
    private String nombre;
    @Column(name = "pvc_region")
    private String region;
    @Column(name = "pvc_poblacion")
    private String poblacion;
    @OneToMany(mappedBy = "provincia")
    private List<Estudiante> estudiante;
    //get y set
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
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
    public List<Estudiante> getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(List<Estudiante> estudiante) {
        this.estudiante = estudiante;
    }
    
    @Override
    public String toString() {
        return "Provincia [id=" + id + ", nombre=" + nombre + ", region=" + region + ", poblacion=" + poblacion + "]";
    }
    

}
