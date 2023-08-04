package com.example.pa2_u3_p4_al_mp.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonaUnaryOperatorImpl implements IPersonaUnaryOperatorFunction<Integer>{
    private static final Logger LOG = LoggerFactory.getLogger(PersonaUnaryOperatorImpl.class);
    @Override
    public Integer aplicar(Integer arg) {
        LOG.info("Class unaryOperator");
        LOG.info("Ret");
        return Math.addExact(arg, 5);
    }
    
}
