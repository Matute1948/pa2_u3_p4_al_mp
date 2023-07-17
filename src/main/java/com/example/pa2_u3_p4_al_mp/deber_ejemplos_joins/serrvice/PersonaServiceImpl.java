package com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.serrvice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository.IPersonaRepository;
import com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository.modelo.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService{
    @Autowired
    private IPersonaRepository personaRepository;
    @Override
    public void agregar(Persona persona) {
        this.personaRepository.insertar(persona);
    }

    @Override
    public void actulizar(Persona persona) {
        this.personaRepository.actulizar(persona);
    }

    @Override
    public void remover(String id) {
        this.personaRepository.eliminar(id);
    }

    @Override
    public Persona buscarPorId(String id) {
        return this.personaRepository.seleccionarPorId(id);
    }

    @Override
    public List<Persona> buscarInnerJoin() {
        return this.personaRepository.seleccionarInnerJoin();
    }

    @Override
    public List<Persona> buscarLeftJoin() {
        return this.personaRepository.seleccionarLeftJoin();
    }

    @Override
    public List<Persona> buscarRightJoin() {
        return this.personaRepository.seleccionarRightJoin();
    }

    @Override
    public List<Persona> buscarFullJoin() {
        return this.personaRepository.seleccionarFullJoin();
    }

    @Override
    public List<Persona> buscarWhereJoin() {
        return this.personaRepository.seleccionarWhereJoin();
    }

    @Override
    public List<Persona> buscarJoinFetch() {
        return this.personaRepository.seleccionarJoinFetch();
    }
    
}
