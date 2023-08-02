package com.example.pa2_u3_p4_al_mp.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
    private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);
    public Integer getId(){
        return 8;
    }
    public static String getIdHo(){
        LOG.info("metodos referenciado HO");
        return "Andres Lugmaña";
    }
    public static String getConsumerHo(String dato){
        LOG.info("metodos referenciado HO");
        return "Andres" + dato;
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
