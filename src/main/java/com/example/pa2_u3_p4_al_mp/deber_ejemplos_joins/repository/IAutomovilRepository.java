package com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository;

import java.util.List;

import com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository.modelo.Automovil;

public interface IAutomovilRepository {
    public void insertar(Automovil automovil);
    public void actulizar(Automovil automovil);
    public void eliminar(String id);
    public Automovil seleccionarPorId(String id);
    public List<Automovil> seleccionarInnerJoin();
    public List<Automovil> seleccionarLeftJoin();
    public List<Automovil> seleccionarRightJoin();
    public List<Automovil> seleccionarFullJoin();
    public List<Automovil> seleccionarWhereJoin();
    public List<Automovil> seleccionarJoinFetch();

}
