package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository;

import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Materia;

public interface IMateriaRepository {
    public void insertar(Materia materia);
    public Materia seleccionarPorCodigo(String codigo);
}
