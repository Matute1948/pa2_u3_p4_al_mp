package com.example.pa2_u3_p4_al_mp.practicaPrueba.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Carro;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Cliente;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Factura;

public interface IFacturaRepository {
    public void insertar(Factura factura);
    public void eliminar(Integer id);
    public void actualizar(Factura factura);
    public Factura seleccionarPorId(Integer id);
    public List<Factura> seleccinarPorFecha(LocalDate fecha);
    public List<Factura> seleccionarTodo();
    public List<Cliente> seleccionarLeft();
    public List<Carro> seleccionarRight();
    
    
}
