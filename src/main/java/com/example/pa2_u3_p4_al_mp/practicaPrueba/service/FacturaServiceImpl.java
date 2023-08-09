package com.example.pa2_u3_p4_al_mp.practicaPrueba.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.IFacturaRepository;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Carro;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Cliente;
import com.example.pa2_u3_p4_al_mp.practicaPrueba.repository.modelo.Factura;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class FacturaServiceImpl implements IFacturaService{
    private static final Logger LOG = LoggerFactory.getLogger(FacturaServiceImpl.class);
    @Autowired
    private IFacturaRepository facturaRepository;
    @Autowired
    private IClienteService clienteService;
    @Autowired
    private ICarroService carroService;

    @Override
    @Transactional(value = TxType.REQUIRED)
    public void agregar(Factura factura) {
        this.facturaRepository.insertar(factura);
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public void borrar(Integer id) {
        this.facturaRepository.eliminar(id);
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public void actualizar(Factura factura) {
        this.facturaRepository.actualizar(factura);
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public Factura buscarPorId(Integer id) {
        return this.facturaRepository.seleccionarPorId(id);
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public List<Factura> buscarPorFecha(LocalDate fecha) {
        return this.facturaRepository.seleccinarPorFecha(fecha);
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public void generar(String ced, String placa) {
        Cliente cliente = this.clienteService.buscarPorCedula(ced);
        Carro carro = this.carroService.buscarPorPlaca(placa);

        
        Factura factura = new Factura();
        factura.setFechaVenta(LocalDate.of(2023, 5, 4));
		factura.setImpuesto(new BigDecimal(12));
		factura.setNombreLocal("Carros :V");
		factura.setCliente(cliente);
		factura.setCarro(carro);
		

		this.agregar(factura);
        if(cliente.getSalario().compareTo(new BigDecimal(100)) > 0){
            LOG.info("Se muere ***************************");
            throw new RuntimeException();
            
        }else{
            LOG.info("No Se muere :v ***************************");
            
        }
        
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public List<Factura> buscarTodo() {
        return this.facturaRepository.seleccionarTodo();
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public List<Cliente> buscarLeft() {
        return this.facturaRepository.seleccionarLeft();
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public List<Carro> buscarRight() {
        return this.facturaRepository.seleccionarRight();
    }
    
}
