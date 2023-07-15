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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarInnerJoin'");
    }

    @Override
    public List<Persona> buscarRightJoin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarRightJoin'");
    }

    @Override
    public List<Persona> buscarFullJoin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarFullJoin'");
    }

    @Override
    public List<Persona> buscarWhereJoin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarWhereJoin'");
    }
    
}
