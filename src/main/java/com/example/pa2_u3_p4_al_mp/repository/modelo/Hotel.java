package com.example.pa2_u3_p4_al_mp.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Table(name="hotel")
@Entity
public class Hotel {
    @GeneratedValue(generator = "seq_hotel", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq hotel", sequenceName = "seq_hotel",allocationSize = 1)
    @Id
    @Column(name = "hot_id")
    private Integer id;
    @Column(name = "hot_nombre")
    private String nombre;
    @Column(name = "hot_direccion")
    private String direccion;
    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Habitacion> habitacion;
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
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public List<Habitacion> getHabitacion() {
        return habitacion;
    }
    public void setHabitacion(List<Habitacion> habitacion) {
        this.habitacion = habitacion;
    }
    @Override
    public String toString() {
        return "Hotel [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion 
                + "]";
    }
    
    
}
