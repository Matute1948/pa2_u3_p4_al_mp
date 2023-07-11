package com.example.pa2_u3_p4_al_mp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pa2_u3_p4_al_mp.serrvice.IHotelService;

@SpringBootApplication
public class Pa2U3P4AlMpApplication implements CommandLineRunner{

	@Autowired
	private IHotelService iHotelService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AlMpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("*********************************************");
		System.out.println(this.iHotelService.buscarInnerJoin());
	}

}
