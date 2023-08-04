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
    public Boolean metodoPredicate(IPersonaPredicate<Integer> funcion,Integer dato){
        LOG.info("High order predicate ");
        funcion.evaluar(dato);
        return dato <= 9;
    }
    public String metodoFunction(IPersonaFuntion<String,Integer> funcion,Integer dato){
        LOG.info("High order function ");
        funcion.aplicar(dato);
        return "ret high order" + dato;
    }
    public Integer metodoUnaryOperator(IPersonaUnaryOperatorFunction<Integer> funcion,Integer dato){
        LOG.info("High order unary Operator ");
        funcion.aplicar(dato);
        LOG.info("ret high order");
        return Math.floorMod(dato, 3);
    }
}
