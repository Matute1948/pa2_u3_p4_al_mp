package com.example.pa2_u3_p4_al_mp.funcional;
@FunctionalInterface
public interface IPersonaPredicate<T> {
    public boolean evaluar(T arg);
}
