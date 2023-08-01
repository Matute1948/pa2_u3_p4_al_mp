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
        //Metodos referenciados
        MetodosReferenciados metodos = new MetodosReferenciados();
        IPersonaSupplier<Integer> supplier4 = metodos::getId;
        LOG.info("Supplier metodo referenciado"+supplier4.getId());

        //2.Consumer
        
        //Clases
        IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
        LOG.info("Consumer clase: ");
        consumer.accept("Andres Lugmana");

        IPersonaConsumer<String> consumer2 = cadena -> LOG.info(cadena);
        LOG.info("Consumer lambda: ");
        consumer2.accept("Andres Lugmana");

        //lambdas
        IPersonaConsumer<String> consumer3 = cadena1 -> {
            LOG.info("1");
            LOG.info("2");
            LOG.info(cadena1);
        };
        LOG.info("Consumer lambda: ");
        consumer3.accept("Andres Lugmana");

        //metodos referenciados
        IPersonaConsumer<String> consumer4 = metodos::aceptar;
        LOG.info("Consumer metodos refernciados");
        consumer4.accept("A");


        //3.- Predicate 
        //lambda
        IPersonaPredicate<Integer> predicate = valor ->valor.compareTo(8) == 0;
        LOG.info("Predicate lambda: "+predicate.evaluar(4));

        IPersonaPredicate<Integer> predicate1 = valor -> {
            Integer valor2 =10;
            valor = valor + valor2;
            if(valor.compareTo(100) > 0){
                return true;
            }else{
                return false;
            }
        };
        LOG.info("Predicate lambda: "+predicate1.evaluar(4));

        IPersonaPredicate<String> predicate2 = valor -> "Andres".contains(valor);
        LOG.info("Predicate lambda nombre: "+predicate2.evaluar("f"));
        // si necesito dos valores se llama bipredicate
        // a todos menos al consumer y suplier
        IPersonaBipredicate<String, Character> bipredicate = (nombre, letra) -> nombre.contains(String.valueOf(letra));
        LOG.info("Bipredicate lambda nombre: "+bipredicate.evaluar("Felipe",'a'));
        
        IPersonaPredicate<Integer> predicate3 = metodos::getBoolean;
        LOG.info("Predicate metodo referenciado"+predicate3.evaluar(4));


        //4.-Funtion
        //IPersonaFuntion<String, Integer> funtion = numero -> numero.toString();
        //LOG.info("Funtion 1 lambda nombre: "+ funtion.aplicar(4));

        //IPersonaFuntion<String, Integer> funtion1 = numero -> {
        //    String valorFinal = numero.toString().concat("Valor");
        //    return valorFinal;
        //};
        //.info("Funtion 2 lambda nombre: "+ funtion1.aplicar(10));
        //5.- UnaryOperator
        /*? 
        IPersonaUnaryOperatorFunction<Integer> unary = numero -> Math.multiplyExact(numero, 3);
        LOG.info("Unary 1 lambda nombre: "+ unary.aplicar(10));

        IPersonaUnaryOperatorFunction<Integer> unary1 = numero -> Math.subtractExact(numero, -2);
        LOG.info("Unary 2 lambda nombre: "+ unary1.aplicar(30));
        */

    }
}
