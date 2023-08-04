package com.example.pa2_u3_p4_al_mp.tarea16;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodoHighOrderT16 {
    private static final Logger LOG = LoggerFactory.getLogger(MetodoHighOrderT16.class);

    public void metodoSupplierT16(IVideojuegoSupplier<String> funcion){
        LOG.info("High order T16 supllier "+ funcion.obtener());
    }

    public void metodoConsumerT16(IVideojuegoConsumer<String> funcion,String dato){
        LOG.info("High order T16 consumer ");
        funcion.accept(dato);
    }
    public void metodoPredicateT16(IVideojuegoPredicate<Integer> funcion,Integer dato){
        LOG.info("High order T16 predicate ");
        LOG.info("Juego costoso "+funcion.evaluar(dato));
    }
    public void metodoFunctionT16(IVideojuegoFunction<String,Integer> funcion,Integer dato){
        LOG.info("High order T16 function ");
        LOG.info(funcion.aplicar(dato));
    }
    public void metodoUnaryOperatorT16(IVideojuegoUnaryOperator<Integer> funcion,Integer dato){
        LOG.info("High order unary T16 Operator ");
        LOG.info("Valor del juego en años antiguos: "+funcion.aplicar(dato));
        
    }
    
}
