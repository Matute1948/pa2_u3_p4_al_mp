package com.example.pa2_u3_p4_al_mp.practicaPrueba.repository;

import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Cliente;

public interface IClienteRepository {
    public void insertar(Cliente cliente);
    public Cliente seleccionarPorCedula(String cedula);
}
