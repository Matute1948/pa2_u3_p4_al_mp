package com.example.pa2_u3_p4_al_mp.funcional;

import org.slf4j.Logger; // debe ser este pilas
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class); // desde ahora este logger para imprimir
    public static void main(String[] args) {
        IPersona persona = new PersonaImpl();
        persona.caminar();
        //1.- Supplier

        //Clases
        IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
        LOG.info("Supplier class"+ supplier.getId());
        //no se usa el Sysmten.out.println
        // la buena practica es un logger

        //Lambdas
        IPersonaSupplier<String> supplier2 = ()-> "1724210685";
        LOG.info("Spplier2 lambda: "+ supplier2.getId());

        IPersonaSupplier<String> supplier3 = ()-> {
            String cedula = "1724210685";
            String cedu= cedula + "Zzzzz";
            return cedu;
        };
        LOG.info("Spplier3 lambda: "+ supplier3.getId());
    }
}
