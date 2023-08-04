package com.example.pa2_u3_p4_al_mp.tarea16;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciadosT16 {
    private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciadosT16.class);
    ///
    public static String getSuppleirHoV1(){
        return "Gof of war";
    }
    public static String getSuppleirHoV2(){
        return "Bayonetta 3";
    }
    public static String getSuppleirHoV3(){
        return "Dragon ball Z Kakarot";
    }
    public static String getSuppleirHoV4(){
        return "Sonic";
    }
    public static String getSuppleirHoV5(){
        return "Zelda y la ocarina del tiempo";
    }
    //
    public static void getConsumerHo(String dato){
        if(dato.length() >10 ){
            LOG.info("El titulo del videojuego " + dato+ " tiene mas de 10 caracteres");
        }else{
            LOG.info("El titulo del videojuego " + dato+ " tiene menos de 10 caracteres");
        }
    }
    //
    public static Boolean getPredicateHo(Integer dato){
        if(dato > 30 ){
            return true;
        }else{
            return false;
        }
    }
    //
    public static String getFunctionHo(Integer dato){
        switch(dato){
            case 60: return "God of war: "+dato;
            case 50: return "Bayonetta 3: "+dato;
            case 40: return "Dragon ball Z Kakarot: "+dato;
            case 30: return "Sonic: "+dato;
            case 55: return "Zelda y la ocarina del tiempo: "+dato;
        }
        return null;
    }
    //
    public static Integer getUnaryOperatorHo(Integer dato){
         if(dato > 30 ){
            return Math.multiplyExact(dato, 3);
        }else{
            return Math.multiplyExact(dato, 2);
        }
    }
}
