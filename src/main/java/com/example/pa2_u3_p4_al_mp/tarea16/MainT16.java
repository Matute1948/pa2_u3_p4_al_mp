package com.example.pa2_u3_p4_al_mp.tarea16;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainT16 {
    private static final Logger LOG = LoggerFactory.getLogger(MainT16.class);
    public static void main(String[] args) {
        MetodoHighOrderT16 highOrder = new MetodoHighOrderT16();
    //Supplier
    LOG.info("*****************************Supplier*****************************");
        //3.- Metodos referenciados
        highOrder.metodoSupplierT16(MetodosReferenciadosT16::getSuppleirHoV1);
        highOrder.metodoSupplierT16(MetodosReferenciadosT16::getSuppleirHoV2);
        highOrder.metodoSupplierT16(MetodosReferenciadosT16::getSuppleirHoV3);
        highOrder.metodoSupplierT16(MetodosReferenciadosT16::getSuppleirHoV4);
        highOrder.metodoSupplierT16(MetodosReferenciadosT16::getSuppleirHoV5);
        LOG.info("*************************Consumer******************************");
        //Consumer
        //3.- MEtodos Referenciales
        highOrder.metodoConsumerT16(MetodosReferenciadosT16::getConsumerHo, "Gof of war");
        highOrder.metodoConsumerT16(MetodosReferenciadosT16::getConsumerHo, "Bayonetta 3");
        highOrder.metodoConsumerT16(MetodosReferenciadosT16::getConsumerHo, "Dragon ball Z Kakarot");
        highOrder.metodoConsumerT16(MetodosReferenciadosT16::getConsumerHo, "Sonic");
        highOrder.metodoConsumerT16(MetodosReferenciadosT16::getConsumerHo, "Zelda y la ocarina del tiempo");

        LOG.info("*************************Predicate*****************************");
        //Predicate
        //3.- Metodos referenciados
        highOrder.metodoPredicateT16(MetodosReferenciadosT16::getPredicateHo, 60);
        highOrder.metodoPredicateT16(MetodosReferenciadosT16::getPredicateHo, 30);
        highOrder.metodoPredicateT16(MetodosReferenciadosT16::getPredicateHo, 60);
        highOrder.metodoPredicateT16(MetodosReferenciadosT16::getPredicateHo, 30);
        highOrder.metodoPredicateT16(MetodosReferenciadosT16::getPredicateHo, 30);
        LOG.info("*************************Function******************************");
        //Function
        //3.- Metodos referenciados
        highOrder.metodoFunctionT16(MetodosReferenciadosT16::getFunctionHo, 60);
        highOrder.metodoFunctionT16(MetodosReferenciadosT16::getFunctionHo, 55);
        highOrder.metodoFunctionT16(MetodosReferenciadosT16::getFunctionHo, 50);
        highOrder.metodoFunctionT16(MetodosReferenciadosT16::getFunctionHo, 40);
        highOrder.metodoFunctionT16(MetodosReferenciadosT16::getFunctionHo, 30);
        LOG.info("*************************Unary Operator*************************");
        //Unary Operator
        //3.- Metodos referenciados
        highOrder.metodoUnaryOperatorT16(MetodosReferenciadosT16::getUnaryOperatorHo, 60);
        highOrder.metodoUnaryOperatorT16(MetodosReferenciadosT16::getUnaryOperatorHo, 30);
        highOrder.metodoUnaryOperatorT16(MetodosReferenciadosT16::getUnaryOperatorHo, 60);
        highOrder.metodoUnaryOperatorT16(MetodosReferenciadosT16::getUnaryOperatorHo, 30);
        highOrder.metodoUnaryOperatorT16(MetodosReferenciadosT16::getUnaryOperatorHo, 60);
        
    }
    
    
}
