package com.example.pa2_u3_p4_al_mp.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
    private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);
    public Integer getId(){
        return 8;
    }
    public static String getIdHo(){
        LOG.info("metodos referenciado supplier HO");
        return "ret supplier Andres Lugmaña";
    }
    public static String getConsumerHo(String dato){
        LOG.info("metodos referenciado consumer HO");
        return "ret consumer Andres" + dato;
    }
    public static Boolean getPredicateHo(Integer dato){
        LOG.info("metodos referenciado predicate HO");
        return (9 >= dato);
    }
    public static String getFunctionHo(Integer dato){
        LOG.info("metodos referenciado function HO");
        return "ret met ref Funtion: "+dato;
    }
    public static Integer getUnaryOperatorHo(Integer dato){
        LOG.info("metodos referenciado unary Operator HO");
        return Math.subtractExact(dato, 9);
    }
    public void aceptar(String arg){
        String cadena = "Andres";
        LOG.info(cadena+" "+arg);
    }

    public Boolean getBoolean(Integer num){
        if (num > 3){
            return true;
        }else{
            return false;
        }
    }

    public String getString(Integer num){

        return "Hola: "+num+" zzz";
    }

    public Integer getInteger(Integer num){

        return Math.multiplyExact(num, num);
    }
}
