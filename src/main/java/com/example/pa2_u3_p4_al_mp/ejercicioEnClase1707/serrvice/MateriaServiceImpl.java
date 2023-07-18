package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.serrvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.IMateriaRepository;
import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService{
    @Autowired
    private IMateriaRepository materiaRepository;
    @Override
    public void agregar(Materia materia) {
        this.materiaRepository.insertar(materia);
    }

    @Override
    public Materia buscarPorCodigo(String codigo) {
        return this.materiaRepository.seleccionarPorCodigo(codigo);
    }
    
}
