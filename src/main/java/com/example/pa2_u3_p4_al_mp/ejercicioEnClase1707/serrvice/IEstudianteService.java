package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.serrvice;

import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Estudiante;

public interface IEstudianteService {
    public void agregar(Estudiante estudiante);
    public Estudiante buscarPorCedula(String cedula);
}
