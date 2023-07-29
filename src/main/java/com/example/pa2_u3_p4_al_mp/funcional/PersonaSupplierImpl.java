package com.example.pa2_u3_p4_al_mp.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String>{

    @Override
    public String getId() {
        String cedula = "1724210685";
        String cedu= cedula + "Zzzzz";
        return cedu;
    }
    
}
