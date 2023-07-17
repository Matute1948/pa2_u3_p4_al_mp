package com.example.pa2_u3_p4_al_mp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository.modelo.Automovil;
import com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.repository.modelo.Persona;
import com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.serrvice.IAutomovilService;
import com.example.pa2_u3_p4_al_mp.deber_ejemplos_joins.serrvice.IPersonaService;

@SpringBootApplication
public class Pa2U3P4AlMpApplication implements CommandLineRunner{

	@Autowired
	private IPersonaService personaService;
	@Autowired
	private IAutomovilService automovilService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AlMpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("***********************************");
		System.out.println("Persona");
		System.out.println("***********************************");
		System.out.println("***********************************");
		System.out.println("Join Inner");
		System.out.println("***********************************");
		List<Persona> lisPer = this.personaService.buscarInnerJoin();
		for (Persona persona : lisPer) {
			System.out.println(persona);
		}

		System.out.println("***********************************");
		System.out.println("Join Right");
		System.out.println("***********************************");
		List<Persona> lisPer1 = this.personaService.buscarRightJoin();
		for (Persona persona : lisPer1) {
			System.out.println(persona);

		}

		System.out.println("***********************************");
		System.out.println("Join Left");
		System.out.println("***********************************");
		List<Persona> lisPer2 = this.personaService.buscarLeftJoin();
		for (Persona persona : lisPer2) {
			System.out.println(persona);
		}

		System.out.println("***********************************");
		System.out.println("Join Full");
		System.out.println("***********************************");
		List<Persona> lisPer3 = this.personaService.buscarFullJoin();
		for (Persona persona : lisPer3) {
			System.out.println(persona);
		}

		System.out.println("***********************************");
		System.out.println("Join Where");
		System.out.println("***********************************");

		List<Persona> lisPer4 = this.personaService.buscarWhereJoin();
		for (Persona persona : lisPer4) {
			System.out.println(persona);
		}
		System.out.println("***********************************");
		System.out.println("Join Fetch");
		System.out.println("***********************************");
		List<Persona> lisPerFetch = this.personaService.buscarJoinFetch();
		for (Persona persona : lisPerFetch) {
			System.out.println(persona.getNombre());
			System.out.println("Tiene los siguientes Automoviles");
			for (Automovil aut : persona.getAutomovil()) {
				System.out.println(aut);
			}
		}
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		System.out.println("***********************************");
		System.out.println("Automovil");
		System.out.println("***********************************");
		System.out.println("***********************************");
		System.out.println("Join Inner");
		System.out.println("***********************************");
		List<Automovil> lisAuto = this.automovilService.buscarInnerJoin();
		for (Automovil automovil : lisAuto) {
			System.out.println(automovil);
		}

		System.out.println("***********************************");
		System.out.println("Join Right");
		System.out.println("***********************************");
		List<Automovil> lisAuto1 = this.automovilService.buscarRightJoin();
		for (Automovil automovil : lisAuto1) {
			System.out.println(automovil);
		}

		System.out.println("***********************************");
		System.out.println("Join Left");
		System.out.println("***********************************");
		List<Automovil> lisAuto2 = this.automovilService.buscarLeftJoin();
		for (Automovil automovil : lisAuto2) {
			System.out.println(automovil);
		}

		System.out.println("***********************************");
		System.out.println("Join Full");
		System.out.println("***********************************");
		List<Automovil> lisAuto3 = this.automovilService.buscarFullJoin();
		for (Automovil automovil : lisAuto3) {
			System.out.println(automovil);
		}

		System.out.println("***********************************");
		System.out.println("Join Where");
		System.out.println("***********************************");

		List<Automovil> lisAuto4 = this.automovilService.buscarWhereJoin();
		for (Automovil automovil : lisAuto4) {
			System.out.println(automovil);
		}
		System.out.println("***********************************");
		System.out.println("Join Fetch");
		System.out.println("***********************************");
		List<Automovil> lisAutoFetch = this.automovilService.buscarJoinFetch();
		for (Automovil automovil : lisAutoFetch) {
			System.out.println(automovil.getMarca());
			System.out.println("Tiene al siguiente dueño");
			System.out.println(automovil.getPersona());
		}
		
	}

}
