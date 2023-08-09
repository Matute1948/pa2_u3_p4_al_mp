package com.example.pa2_u3_p4_al_mp.practicaPrueba.repository;

import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Carro;

public interface ICarroRepository {
    public void insertar(Carro automovil);
    public Carro seleccionarPorPlaca(String placa);
    
}
