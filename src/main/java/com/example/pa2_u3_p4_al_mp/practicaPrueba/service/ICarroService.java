package com.example.pa2_u3_p4_al_mp.practicaPrueba.service;

import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Carro;

public interface ICarroService {
    public void agregar(Carro automovil);
    public Carro  buscarPorPlaca(String placa);
}
