package com.example.pa2_u3_p4_al_mp.practicaPrueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.IClienteRepository;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Cliente;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ClienteServiceImpl implements IClienteService{
    @Autowired
    private IClienteRepository clienteRepository;
    @Override
    @Transactional(value = TxType.REQUIRED)
    public void agregar(Cliente cliente) {
        this.clienteRepository.insertar(cliente);
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public Cliente buscarPorCedula(String cedula) {
        return this.clienteRepository.seleccionarPorCedula(cedula);
    }
    
}
