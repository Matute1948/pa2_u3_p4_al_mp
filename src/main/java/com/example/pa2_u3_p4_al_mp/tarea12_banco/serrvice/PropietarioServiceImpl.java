package com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.IPropietarioRepository;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.Propietario;
import jakarta.transaction.Transactional;

@Service
public class PropietarioServiceImpl implements IPropietarioService{
    @Autowired
    private IPropietarioRepository propietarioRepository;
    @Autowired
    private IPruebaService pruebaService;

    @Override
    //@Transactional //transaccion abierta
    public void agregar(Propietario propietario) {
        System.out.println("service"+TransactionSynchronizationManager.isActualTransactionActive());
        //this.propietarioRepository.insertar(propietario);
        //this.pruebaService.prueba(); // funcion aqui porque debe ser la transaccion en la mismo metodo
        //this.pruebaService.prueba2();
        //this.pruebaService.pruebaSupports();
        //this.pruebaService.pruebaNotSupported();
        //this.pruebaService.pruebaRequired();
        this.pruebaService.pruebaRequiredNew();
    
    }

    @Override
    public void actulizar(Propietario propietario) {
        this.propietarioRepository.actulizar(propietario);
    }

    @Override
    public void remover(String id) {
        this.propietarioRepository.eliminar(id);
    }

    @Override
    public Propietario buscarPorId(String id) {
        return this.propietarioRepository.seleccionarPorId(id);
    }
    
}
