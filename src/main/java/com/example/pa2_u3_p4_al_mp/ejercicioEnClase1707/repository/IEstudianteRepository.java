package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository;

import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    
    public void insertar(Estudiante estudiante);
    public Estudiante seleccionarPorCedula(String cedula);
}
