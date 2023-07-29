package com.example.pa2_u3_p4_al_mp.funcional;
@FunctionalInterface
public interface IPersonaFuntion<T, R> {
    public T aplicar(R arg);
}
