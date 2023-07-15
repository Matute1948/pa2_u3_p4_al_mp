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
import com.example.pa2_u3_p4_al_mp.repository.modelo.Habitacion;
import com.example.pa2_u3_p4_al_mp.repository.modelo.Hotel;
import com.example.pa2_u3_p4_al_mp.serrvice.IHotelService;

@SpringBootApplication
public class Pa2U3P4AlMpApplication implements CommandLineRunner{

	@Autowired
	private IHotelService iHotelService;
	@Autowired
	private IPersonaService personaService;
	@Autowired
	private IAutomovilService automovilService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AlMpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Hotel hotell = new Hotel();
		hotell.setDireccion("Selva Alegra");
		hotell.setNombre("Picos Helados");
		
		Habitacion hab1 = new Habitacion();
		hab1.setHotel(hotell);
		hab1.setNumero("10");
		hab1.setValor(new BigDecimal(20));

		Habitacion hab2 = new Habitacion();
		hab2.setHotel(hotell);
		hab2.setNumero("11");
		hab2.setValor(new BigDecimal(30));

		List<Habitacion> listHab = new ArrayList<>();
		listHab.add(hab2);
		listHab.add(hab1);
		hotell.setHabitacion(listHab);
		this.iHotelService.agregar(hotell);
		


	
		List<Hotel> lisHot = this.iHotelService.buscarInnerJoin();
		for (Hotel hotel : lisHot) {
			System.out.println(hotel.getNombre());
			System.out.println("Tiene las siguientes Habitacion");
			for (Habitacion hab : hotel.getHabitacion()) {
				System.out.println(hab);
			}
		}
		System.out.println("***********************************");
		System.out.println("Join Fetch");
		System.out.println("***********************************");
		List<Hotel> lisHotFetch = this.iHotelService.buscarFetchJoin();
		for (Hotel hotel : lisHotFetch) {
			System.out.println(hotel.getNombre());
			System.out.println("Tiene las siguientes Habitacion");
			for (Habitacion hab : hotel.getHabitacion()) {
				System.out.println(hab);
			}
		}
		
	}

}
