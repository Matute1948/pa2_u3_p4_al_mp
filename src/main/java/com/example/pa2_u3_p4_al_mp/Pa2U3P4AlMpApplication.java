package com.example.pa2_u3_p4_al_mp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Estudiante;
import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Materia;
import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Provincia;
import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Semestre;
import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.serrvice.IEstudianteService;
import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.serrvice.IMateriaService;
import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.serrvice.IMatriculaService;

@SpringBootApplication
public class Pa2U3P4AlMpApplication implements CommandLineRunner{

	@Autowired
	private IEstudianteService estudianteService;
	@Autowired
	private IMateriaService materiaService;
	@Autowired
	private IMatriculaService matriculaService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AlMpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Estudiante> listEst = new ArrayList<>();
		List<Materia> listMat = new ArrayList<>();
		List<String> lisCodigo = new ArrayList<>();
		
		Estudiante estu1 = new Estudiante();
		Estudiante estu2 = new Estudiante();
		Estudiante estu3 = new Estudiante();
		Estudiante estu4 = new Estudiante();

		Provincia pro1 = new Provincia();
		Provincia pro2 = new Provincia();
		Provincia pro3 = new Provincia();
		Provincia pro4 = new Provincia();

		Materia mat1 = new Materia();
		Materia mat2 = new Materia();
		Materia mat3 = new Materia();
		Materia mat4 = new Materia();

		Semestre smt1 = new Semestre();


		estu1.setNombre("Andres");
		estu1.setApellido("Lugmaña");
		estu1.setCedula("123456789");
		estu1.setProvincia(pro1);

		estu2.setNombre("Felipe");
		estu2.setApellido("Achig");
		estu2.setCedula("123456781");
		estu2.setProvincia(pro2);

		estu3.setNombre("Arelis");
		estu3.setApellido("Cacuango");
		estu3.setCedula("123456782");
		estu3.setProvincia(pro3);

		estu4.setNombre("Jhomara");
		estu4.setApellido("Chuquin");
		estu4.setCedula("123456783");
		estu4.setProvincia(pro4);

		listEst.add(estu1);
		listEst.add(estu2);
		listEst.add(estu3);
		listEst.add(estu4);

		pro1.setNombre("Pichinca");
		pro1.setPoblacion("50000");
		pro1.setRegion("Sierra");
		pro1.setEstudiante(listEst);

		pro2.setNombre("Esmeraldas");
		pro2.setPoblacion("30000");
		pro2.setRegion("Costa");
		pro2.setEstudiante(listEst);

		pro3.setNombre("Tena");
		pro3.setPoblacion("20000");
		pro3.setRegion("Oriente");
		pro3.setEstudiante(listEst);

		pro4.setNombre("Cuenca");
		pro4.setPoblacion("50000");
		pro4.setRegion("Sierra");
		pro4.setEstudiante(listEst);

		mat1.setNombre("Fisica");
		mat1.setCodigo("FSC");
		mat1.setCosto(new BigDecimal(30));
		mat1.setSemestre(smt1);

		mat2.setNombre("Calculo");
		mat2.setCodigo("CLO");
		mat2.setCosto(new BigDecimal(40));
		mat2.setSemestre(smt1);

		mat3.setNombre("Programacion");
		mat3.setCodigo("PGM");
		mat3.setCosto(new BigDecimal(20));
		mat3.setSemestre(smt1);

		mat4.setNombre("Base de Datos");
		mat4.setCodigo("BDD");
		mat4.setCosto(new BigDecimal(30));
		mat4.setSemestre(smt1);

		listMat.add(mat1);
		listMat.add(mat2);
		listMat.add(mat3);
		listMat.add(mat4);

		lisCodigo.add(mat1.getCodigo());
		lisCodigo.add(mat2.getCodigo());
		lisCodigo.add(mat3.getCodigo());
		lisCodigo.add(mat4.getCodigo());

		smt1.setFechaInicio(LocalDate.of(2023, 2, 12));
		smt1.setFechaFin(LocalDate.of(2023, 6, 12));
		smt1.setMateria(listMat);
		smt1.setNumero("Primer semestre");

		//this.estudianteService.agregar(estu1);
		//this.materiaService.agregar(mat1);

		this.matriculaService.realizar("123456789", lisCodigo);
		this.matriculaService.realizar("123456781", lisCodigo);
		this.matriculaService.realizar("123456782", lisCodigo);
		this.matriculaService.realizar("123456783", lisCodigo);
	}

}
