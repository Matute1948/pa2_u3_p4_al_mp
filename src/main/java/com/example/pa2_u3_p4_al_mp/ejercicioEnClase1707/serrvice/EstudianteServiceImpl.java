package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.serrvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.IEstudianteRepository;
import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
    @Autowired
    private IEstudianteRepository estudianteRepository;
    @Override
    public void agregar(Estudiante estudiante) {
        this.estudianteRepository.insertar(estudiante);
    }

    @Override
    public Estudiante buscarPorCedula(String cedula) {
        return this.estudianteRepository.seleccionarPorCedula(cedula);
    }
    
}
