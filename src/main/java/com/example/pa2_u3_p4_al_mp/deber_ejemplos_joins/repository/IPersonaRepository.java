package com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository;

import java.util.List;

import com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository.modelo.Persona;

public interface IPersonaRepository {
    public void insertar(Persona persona);
    public void actulizar(Persona persona);
    public void eliminar(String id);
    public Persona seleccionarPorId(String id);
    public List<Persona> seleccionarInnerJoin();
    public List<Persona> seleccionarRightJoin();
    public List<Persona> seleccionarFullJoin();
    public List<Persona> seleccionarWhereJoin();
}
