package com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.Propietario;

public interface IPropietarioService {
    public void agregar(Propietario propietario);
    public void actulizar(Propietario propietario);
    public void remover(String id);
    public Propietario buscarPorId(String id);
}
