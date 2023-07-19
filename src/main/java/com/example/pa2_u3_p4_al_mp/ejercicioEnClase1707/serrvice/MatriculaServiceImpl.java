package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.serrvice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.IMatriculaRepository;
import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements IMatriculaService{
    @Autowired
    private IMatriculaRepository matriculaRepository;
    @Autowired
    private IEstudianteService estudianteService;
    @Autowired
    private IMateriaService materiaService;
    @Override
    public void agregar(Matricula matricula) {
        this.matriculaRepository.insertar(matricula);
    }

    @Override
    public void realizar(String cedulaEstudiante, List<String> codigoMateria) {
        int con = 0;
        for (String codigo : codigoMateria) {
            con++;
            Matricula matricula =new Matricula();
            matricula.setFecha(LocalDate.now());
            matricula.setRepetida(false);
            matricula.setNumero(String.valueOf(con));
            matricula.setMateria(this.materiaService.buscarPorCodigo(codigo));
            matricula.setEstudiante(this.estudianteService.buscarPorCedula(cedulaEstudiante));
            this.agregar(matricula);
        }
    }
    
}
