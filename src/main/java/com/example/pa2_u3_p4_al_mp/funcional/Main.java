package com.example.pa2_u3_p4_al_mp.funcional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger; // debe ser este pilas
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class); // desde ahora este logger para imprimir
    public static void main(String[] args) {
        IPersona persona = new PersonaImpl();
        persona.caminar();
        //*************************************************************************************
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

        //*************************************************************************************
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

        //**********************************************************************************
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

        //********************************************************************************
        //4.-Funtion
        IPersonaFuntion<String, Integer> funtion = numero -> numero.toString();
        LOG.info("Funtion 1 lambda nombre: "+ funtion.aplicar(4));

        IPersonaFuntion<String, Integer> funtion1 = numero -> {
            String valorFinal = numero.toString().concat("Valor");
            return valorFinal;
        };
        LOG.info("Funtion 2 lambda nombre: "+ funtion1.aplicar(10));

        //Metodos Referenciados
        IPersonaFuntion<String, Integer> funtion2 = metodos::getString;
        LOG.info("Funtion Metodos Refernciados ");
        LOG.info(funtion2.aplicar(666));
        

        //*********************************************************************************
        //5.- UnaryOperator
         
        IPersonaUnaryOperatorFunction<Integer> unary = numero -> Math.multiplyExact(numero, 3);
        LOG.info("Unary 1 lambda nombre: "+ unary.aplicar(10));

        IPersonaUnaryOperatorFunction<Integer> unary1 = numero -> Math.subtractExact(numero, 20);
        LOG.info("Unary 2 lambda nombre: "+ unary1.aplicar(30));
        
        //Metodos Referenciados

        IPersonaUnaryOperatorFunction<Integer> unary2 = metodos::getInteger;
        LOG.info("Unary Metodos Refernciados ");
        LOG.info(""+unary2.aplicar(7));

        LOG.info("*******************************************************************");
        //*************************Metodos high order******************
        //Supplier
        // 1.- Clase
        MetodoHighOrder highOrder = new MetodoHighOrder();
        IPersonaSupplier<String> supplierHO = new PersonaSupplierImpl();
        highOrder.metodo(supplierHO);
        //2.- Lambdas
        highOrder.metodo(() -> "123456789HO");
        //3.- Metodos referenciados
        highOrder.metodo(MetodosReferenciados::getIdHo);

        LOG.info("*******************************************************************");
        //Consumer
        //1.- Clase 
        IPersonaConsumer<String> consumerHO = new PersonaConsumerImpl();
        highOrder.metodoConsumer(consumerHO, "Andres");
        //2.- lambda
        highOrder.metodoConsumer((para) -> LOG.info(para), "Lambda Cosumer HO");
        //3.- MEtodos Referenciales
        highOrder.metodoConsumer(MetodosReferenciados::getConsumerHo, "MF HO");
        LOG.info("*******************************************************************");
        //Predicate
        //1.- Clase 
        IPersonaPredicate<Integer> predicateHO = new PersonaPredicateImpl();
        highOrder.metodoPredicate(predicateHO, 19);
        //2.- lambdas
        highOrder.metodoPredicate((pre)->Math.subtractExact(pre, 7) <= 5, 23);
        //3.- Metodos referenciados
        highOrder.metodoPredicate(MetodosReferenciados::getPredicateHo, 13);
        LOG.info("*******************************************************************");
        //Function
        //1.- Clase 
        IPersonaFuntion<String,Integer> functionHO = new PersonaFunctionImpl();
        LOG.info(highOrder.metodoFunction(functionHO, 19));
        //2.- lambdas
        LOG.info(highOrder.metodoFunction((pre)->"fl F"+pre, 23));
        //3.- Metodos referenciados
        LOG.info(highOrder.metodoFunction(MetodosReferenciados::getFunctionHo, 13));
        LOG.info("*******************************************************************");
        //Unary Operator
        //1.- Clase 
        IPersonaUnaryOperatorFunction<Integer> unaryHO = new PersonaUnaryOperatorImpl();
        highOrder.metodoUnaryOperator(unaryHO, 19);
        //2.- lambdas
        highOrder.metodoUnaryOperator((pre)->Math.subtractExact(pre, 5), 23);
        //3.- Metodos referenciados
        highOrder.metodoUnaryOperator(MetodosReferenciados::getUnaryOperatorHo, 13);


        /* 
        //Interfaces Funcionales JAVA
        //1.- Supplier
        Stream<String> lista = Stream.generate(() -> "1234567890").limit(10); // genera una lista  de 10 elementos
        lista.forEach(cadena -> LOG.info(cadena));
        LOG.info("Prueba"+lista);

        //2.- Consumer
        List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5,6,7,8,9);
        listaNumeros.forEach(cadena ->{
            LOG.info(""+cadena);
        });

        //3.- Predicate 
        Stream<Integer> listaFinal = listaNumeros.stream().filter(numero->numero>=5);
        listaFinal.forEach(numero -> LOG.info(("valor: "+numero)));

        //4.. Funtion
        Stream<String> listaCambiada=listaNumeros.stream().map(numero ->{
            Integer num=10;
            num = num + numero;
            return "N" + num;
        });
        listaCambiada.forEach(cadena -> LOG.info(cadena));

        //5.- unary Operation
        Stream<String> listaCambiada2=listaNumeros.stream().map(numero ->{
            Integer num=10;
            num = num + numero;
            return "N" + num;
        });
        listaCambiada2.forEach(cadena -> LOG.info(cadena.toString()));
        */


    }
}
