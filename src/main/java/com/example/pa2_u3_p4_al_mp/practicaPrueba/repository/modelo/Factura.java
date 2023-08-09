package com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name ="factura")
@Entity
public class Factura {
    @GeneratedValue(generator = "seq_factura", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_factura", sequenceName = "seq_factura",allocationSize = 1)
    @Id
    @Column(name ="fac_id")
    private Integer id;
    @Column(name ="fac_fecha_venta")
    private LocalDate fechaVenta;
    @Column(name ="fac_nombre_local")
    private String nombreLocal;
    @Column(name ="fac_impuesto")
    private BigDecimal impuesto;
    @ManyToOne()
    @JoinColumn(name = "fac_id_cliente")
    private Cliente cliente;
    @ManyToOne()
    @JoinColumn(name = "fac_id_carro")
    private Carro carro;;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getFechaVenta() {
        return fechaVenta;
    }
    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    public String getNombreLocal() {
        return nombreLocal;
    }
    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }
    public BigDecimal getImpuesto() {
        return impuesto;
    }
    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Carro getCarro() {
        return carro;
    }
    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    @Override
    public String toString() {
        return "Factura [id=" + id + ", fechaVenta=" + fechaVenta + ", nombreLocal=" + nombreLocal + ", impuesto="
                + impuesto + "]";
    }
    
}
