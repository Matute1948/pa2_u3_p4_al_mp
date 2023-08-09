package com.example.pa2_u3_p4_al_mp.practicaPrueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.ICarroRepository;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Carro;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class CarroServiceImpl implements ICarroService{
    @Autowired
    private ICarroRepository carroRepository;
    @Override
    @Transactional(value = TxType.REQUIRED)
    public void agregar(Carro carro) {
        this.carroRepository.insertar(carro);
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public Carro buscarPorPlaca(String placa) {
        return this.carroRepository.seleccionarPorPlaca(placa);
    }
    
}
