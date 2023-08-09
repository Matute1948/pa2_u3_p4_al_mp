package com.example.pa2_u3_p4_al_mp;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Carro;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Cliente;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Factura;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.service.ICarroService;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.service.IClienteService;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.service.IFacturaService;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.CuentaBancaria;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice.ICuentaBancariaService;


@SpringBootApplication 
@EnableAsync // con esto habilitamos el proceso asincronico
public class Pa2U3P4AlMpApplication implements CommandLineRunner{
	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4AlMpApplication.class);
	@Autowired
	private IClienteService clienteService;
	@Autowired 
	private ICarroService carroService;
	@Autowired
	private IFacturaService facturaService;
	@Autowired
	private ICuentaBancariaService cuentaBancariaService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AlMpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/* asincrono sin respuesta
		//inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CuentaBancaria> lista = new ArrayList<>();

		for(int i=0; i<= 100; i++){
			CuentaBancaria cta = new CuentaBancaria();
			cta.setNumero(""+i);
			cta.setPropietario(null);
			cta.setSaldo(new BigDecimal(10));
			cta.setTipo("re");
			lista.add(cta);
			this.cuentaBancariaService.agregarAsincrono(cta); // se demora 10 milisegundos por que no espera la respuesta
		}

		//lista.stream().forEach(cta ->  this.cuentaBancariaService.agregar(cta));
		//lista.parallelStream().forEach(cta ->  this.cuentaBancariaService.agregar(cta));
		//lista.parallelStream().forEach(cta ->  LOG.info("Se inserto la cta: "+this.cuentaBancariaService.agregar2(cta)));
		//lista.parallelStream().map(cta -> this.cuentaBancariaService.agregar2(cta)).forEach(x->LOG.info("Cuenta insertada: "+x));;
		//List<String> listaFinal = lista.parallelStream().map(cta -> this.cuentaBancariaService.agregar2(cta))
		//				.collect(Collectors.toList());

		//fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoFinal - tiempoInicial;
		LOG.info("***************************************tiempo transcurrido: " + tiempoTranscurrido/1000);
		*/

		// asincrono con respuesta
		//inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CuentaBancaria> lista = new ArrayList<>();
		List<CompletableFuture<String>> listRepuesta = new ArrayList<>();

		for(int i=0; i<= 10; i++){
			CuentaBancaria cta = new CuentaBancaria();
			cta.setNumero(""+i);
			cta.setPropietario(null);
			cta.setSaldo(new BigDecimal(10));
			cta.setTipo("re");
			lista.add(cta);
			CompletableFuture<String> respuesta = this.cuentaBancariaService.agregarAsincrono2(cta); // se demora 10 milisegundos por que no espera la respuesta
			listRepuesta.add(respuesta);
		}
		//sentecia que espera la respuesta de lo hilos
		CompletableFuture.allOf(listRepuesta.get(0),listRepuesta.get(1),listRepuesta.get(2),
		listRepuesta.get(3),listRepuesta.get(4),listRepuesta.get(5),listRepuesta.get(6),listRepuesta.get(7),
		listRepuesta.get(8),listRepuesta.get(9));

		LOG.info("Respuesta 0:" +listRepuesta.get(0).get());

		//fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoFinal - tiempoInicial;
		LOG.info("***************************************tiempo transcurrido: " + tiempoTranscurrido/1000);
		
		
	}

}
