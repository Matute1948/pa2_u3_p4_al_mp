package com.example.pa2_u3_p4_al_mp.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonaFunctionImpl implements IPersonaFuntion<String,Integer>{
    private static final Logger LOG = LoggerFactory.getLogger(PersonaFunctionImpl.class);
    @Override
    public String aplicar(Integer arg) {
        LOG.info("Function class: ");
        return "ret ClassImpl Funtion: " + arg;
    }
    
}
