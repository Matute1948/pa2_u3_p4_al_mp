package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.serrvice;

import java.util.List;

import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Matricula;

public interface IMatriculaService {
    public void agregar(Matricula matricula);
    public void realizar(String cedulaEstudiante, List<String> codigoMateria);
}
