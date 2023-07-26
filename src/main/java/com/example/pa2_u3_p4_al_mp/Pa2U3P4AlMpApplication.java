package com.example.pa2_u3_p4_al_mp;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.CuentaBancaria;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.Propietario;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice.IPropietarioService;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice.ITransferenciaService;


@SpringBootApplication
public class Pa2U3P4AlMpApplication implements CommandLineRunner{
	@Autowired
	private IPropietarioService propietarioService;
	@Autowired
	private ITransferenciaService transferenciaService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AlMpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Nos dice si hay una transaccion activa
		System.out.println("main"+TransactionSynchronizationManager.isActualTransactionActive());
		Propietario prop = new Propietario();
		prop.setNombre("Jho");
		prop.setApellido("Ca");
		prop.setCedula("543");
		this.propietarioService.agregar(prop);

		this.transferenciaService.procesoTransferencia("675849237", "123456789", new BigDecimal(300));
		
		
		
	}

}
