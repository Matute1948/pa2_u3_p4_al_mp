package com.example.pa2_u3_p4_al_mp.practicaPrueba.service;

import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Cliente;

public interface IClienteService {
    
    public void agregar(Cliente cliente);
    public Cliente buscarPorCedula(String cedula);
}
