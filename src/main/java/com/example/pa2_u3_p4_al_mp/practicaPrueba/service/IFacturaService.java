package com.example.pa2_u3_p4_al_mp.practicaPrueba.service;

import java.time.LocalDate;
import java.util.List;

import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Carro;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Cliente;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Factura;

public interface IFacturaService {
    public void agregar(Factura factura);
    public void borrar(Integer id);
    public void actualizar(Factura factura);
    public Factura buscarPorId(Integer id);
    public List<Factura> buscarPorFecha(LocalDate fecha);
    public void generar(String ced, String placa);
    public List<Factura> buscarTodo();
    public List<Cliente> buscarLeft();
    public List<Carro> buscarRight();
}
