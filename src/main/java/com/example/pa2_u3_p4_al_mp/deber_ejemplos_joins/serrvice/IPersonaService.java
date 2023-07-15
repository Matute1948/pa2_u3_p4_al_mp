package com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.serrvice;

import java.util.List;

import com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository.modelo.Persona;

public interface IPersonaService {
    public void agregar(Persona persona);
    public void actulizar(Persona persona);
    public void remover(String id);
    public Persona buscarPorId(String id);
    public List<Persona> buscarInnerJoin();
    public List<Persona> buscarRightJoin();
    public List<Persona> buscarFullJoin();
    public List<Persona> buscarWhereJoin();
}
