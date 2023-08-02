package com.example.pa2_u3_p4_al_mp.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodoHighOrder {
    private static final Logger LOG = LoggerFactory.getLogger(MetodoHighOrder.class);
    public void metodo(IPersonaSupplier<String> funcion){
        LOG.info("High order supllier "+ funcion.getId());
    }

    public void metodoConsumer(IPersonaConsumer<String> funcion,String dato){
        LOG.info("High order consumer ");
        funcion.accept(dato);
    }
    
}
