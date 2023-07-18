package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.serrvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.IMatriculaRepository;
import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements IMatriculaService{
    @Autowired
    private IMatriculaRepository matriculaRepository;
    @Override
    public void agregar(Matricula matricula) {
        this.matriculaRepository.insertar(matricula);
    }

    @Override
    public void procesoMatricula(String cedulaEstudiante, String codigoMateria) {
        this.matriculaRepository.realizar(cedulaEstudiante, codigoMateria);
    }
    
}
