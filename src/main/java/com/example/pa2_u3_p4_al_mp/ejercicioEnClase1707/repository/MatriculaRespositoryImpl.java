package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaRespositoryImpl implements IMatriculaRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private IEstudianteRepository estudianteRepository;
    @Autowired
    private IMateriaRepository materiaRepository;
    @Override
    public void insertar(Matricula matricula) {
        this.entityManager.persist(matricula);
    }

    @Override
    public void realizar(String cedulaEstudiante, String codigoMateria) {
        Matricula matricula = new Matricula();
        matricula.setFecha(LocalDate.of(2023, 7, 27));
        matricula.setNumero("001");
        matricula.setEstudiante(this.estudianteRepository.seleccionarPorCedula(cedulaEstudiante));
        matricula.setMateria(this.materiaRepository.seleccionarPorCodigo(codigoMateria));
        this.insertar(matricula);
    }
}
