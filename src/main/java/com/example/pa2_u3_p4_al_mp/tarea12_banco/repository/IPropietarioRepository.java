package com.example.pa2_u3_p4_al_mp.tarea12_banco.repository;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.Propietario;

public interface IPropietarioRepository {
    public void insertar(Propietario propietario);
    public void actulizar(Propietario propietario);
    public void eliminar(String id);
    public Propietario seleccionarPorId(String id);
}
