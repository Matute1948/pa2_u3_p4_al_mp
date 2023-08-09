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

@Table(name = "carro")
@Entity
public class Carro {
    @GeneratedValue(generator = "seq_carro", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_carro", sequenceName = "seq_carro",allocationSize = 1)
    @Id
    @Column(name ="car_id")
    private Integer id;
    @Column(name ="car_marca")
    private String marca;
    @Column(name = "car_placa")
    private String placa;
    @Column(name ="car_costo")
    private BigDecimal costo;
    @Column(name ="car_region")
    private String region;
    @OneToMany(mappedBy = "carro")
    private List<Factura> listFac;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public BigDecimal getCosto() {
        return costo;
    }
    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public List<Factura> getListFac() {
        return listFac;
    }
    public void setListFac(List<Factura> listFac) {
        this.listFac = listFac;
    }
    @Override
    public String toString() {
        return "Carro [id=" + id + ", marca=" + marca + ", placa=" + placa + ", costo=" + costo + ", region=" + region
                + "]";
    }
    
    
    

    

    



    
    
}
