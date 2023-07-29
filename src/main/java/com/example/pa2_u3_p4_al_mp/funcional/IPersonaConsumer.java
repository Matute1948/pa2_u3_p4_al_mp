package com.example.pa2_u3_p4_al_mp.funcional;
@FunctionalInterface
public interface IPersonaConsumer<T> {
    public void accept(T arg);
}
