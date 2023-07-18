package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.serrvice;

import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Materia;

public interface IMateriaService {
    public void agregar(Materia materia);
    public Materia buscarPorCodigo(String codigo);
}
