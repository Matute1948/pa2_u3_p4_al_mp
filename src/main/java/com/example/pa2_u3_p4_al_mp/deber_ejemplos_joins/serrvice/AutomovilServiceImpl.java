package com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.serrvice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository.IAutomovilRepository;
import com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository.modelo.Automovil;

@Service
public class AutomovilServiceImpl implements IAutomovilService{
    @Autowired
    private IAutomovilRepository automovilRepository;
    @Override
    public void agregar(Automovil automovil) {
        this.automovilRepository.insertar(automovil);
    }

    @Override
    public void actulizar(Automovil automovil) {
        this.automovilRepository.actulizar(automovil);
    }

    @Override
    public void remover(String id) {
        this.automovilRepository.eliminar(id);
    }

    @Override
    public Automovil buscarPorId(String id) {
        return this.automovilRepository.seleccionarPorId(id);
    }

    @Override
    public List<Automovil> buscarInnerJoin() {
        return this.automovilRepository.seleccionarInnerJoin();
    }

    @Override
    public List<Automovil> buscarLeftJoin() {
        return this.automovilRepository.seleccionarLeftJoin();
    }

    @Override
    public List<Automovil> buscarRightJoin() {
        return this.automovilRepository.seleccionarRightJoin();
    }

    @Override
    public List<Automovil> buscarFullJoin() {
        return this.automovilRepository.seleccionarFullJoin();
    }

    @Override
    public List<Automovil> buscarWhereJoin() {
        return this.automovilRepository.seleccionarWhereJoin();
    }

    @Override
    public List<Automovil> buscarJoinFetch() {
        return this.automovilRepository.seleccionarJoinFetch();
    }
    
}
