package com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.serrvice;

import java.util.List;

import com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository.modelo.Automovil;

public interface IAutomovilService {
    public void agregar(Automovil automovil);
    public void actulizar(Automovil automovil);
    public void remover(String id);
    public Automovil buscarPorId(String id);
    public List<Automovil> buscarInnerJoin();
    public List<Automovil> buscarLeftJoin();
    public List<Automovil> buscarRightJoin();
    public List<Automovil> buscarFullJoin();
    public List<Automovil> buscarWhereJoin();
    public List<Automovil> buscarJoinFetch();
}
