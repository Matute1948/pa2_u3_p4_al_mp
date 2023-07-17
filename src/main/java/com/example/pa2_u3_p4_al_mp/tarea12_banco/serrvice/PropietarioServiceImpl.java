package com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.IPropietarioRepository;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.Propietario;

@Service
public class PropietarioServiceImpl implements IPropietarioService{
    @Autowired
    private IPropietarioRepository propietarioRepository;
    @Override
    public void agregar(Propietario propietario) {
        this.propietarioRepository.insertar(propietario);
    }

    @Override
    public void actulizar(Propietario propietario) {
        this.propietarioRepository.actulizar(propietario);
    }

    @Override
    public void remover(String id) {
        this.propietarioRepository.eliminar(id);
    }

    @Override
    public Propietario buscarPorId(String id) {
        return this.propietarioRepository.seleccionarPorId(id);
    }
    
}
