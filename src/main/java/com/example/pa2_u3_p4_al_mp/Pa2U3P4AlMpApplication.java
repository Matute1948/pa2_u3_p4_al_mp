package com.example.pa2_u3_p4_al_mp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.CuentaBancaria;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.Propietario;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.Transferencia;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice.ICuentaBancariaService;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice.ITransferenciaService;

@SpringBootApplication
public class Pa2U3P4AlMpApplication implements CommandLineRunner{

	@Autowired
	private ICuentaBancariaService cuentaBancariaService;
	@Autowired
	private ITransferenciaService transferenciaService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AlMpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Propietario prop1 = new Propietario();
		Propietario prop2 = new Propietario();
		Propietario prop3 = new Propietario();
		Propietario prop4 = new Propietario();

		prop1.setNombre("Andres");
		prop1.setApellido("Lugmaña");
		prop1.setCedula("1724210685");

		prop2.setNombre("Alfredo");
		prop2.setApellido("Vargas");
		prop2.setCedula("1735465879");

		prop3.setNombre("Tairo");
		prop3.setApellido("Iñigas");
		prop3.setCedula("1735465634");

		prop4.setNombre("Jhomara");
		prop4.setApellido("Cacuango");
		prop4.setCedula("1473534289");

		CuentaBancaria cuenta1 = new CuentaBancaria();
		CuentaBancaria cuenta2 = new CuentaBancaria();
		CuentaBancaria cuenta3 = new CuentaBancaria();
		CuentaBancaria cuenta4 = new CuentaBancaria();

		cuenta1.setNumero("123456789");
		cuenta1.setPropietario(prop1);
		cuenta1.setSaldo(new BigDecimal(200));
		cuenta1.setTipo("A");

		cuenta2.setNumero("987654321");
		cuenta2.setPropietario(prop2);
		cuenta2.setSaldo(new BigDecimal(100));
		cuenta2.setTipo("A");

		cuenta3.setNumero("675849237");
		cuenta3.setPropietario(prop3);
		cuenta3.setSaldo(new BigDecimal(300));
		cuenta3.setTipo("C");

		cuenta4.setNumero("769305386");
		cuenta4.setPropietario(prop4);
		cuenta4.setSaldo(new BigDecimal(50));
		cuenta4.setTipo("C");

		this.cuentaBancariaService.agregar(cuenta1);
		this.cuentaBancariaService.agregar(cuenta2);
		this.cuentaBancariaService.agregar(cuenta3);
		this.cuentaBancariaService.agregar(cuenta4);

		this.transferenciaService.procesoTransferencia("123456789", "987654321", new BigDecimal(30));
		this.transferenciaService.procesoTransferencia("675849237", "769305386", new BigDecimal(50));

		List<Transferencia> reportTra = this.transferenciaService.reporteTodoTransferencias();
		int con = 0;
		for (Transferencia transferencia : reportTra) {
			con++;
			System.out.println("*************Transferencia " +con+"*****************");
			System.out.println("Fecha: "+transferencia.getFecha());
			System.out.println("Monto: "+transferencia.getMonto());
			System.out.println("Cuenta Origen: "+transferencia.getCtaOrigen());
			System.out.println("Cuenta Destino: "+transferencia.getCtaDestino());
		}
		System.out.println("************************************************************");


	}

}
