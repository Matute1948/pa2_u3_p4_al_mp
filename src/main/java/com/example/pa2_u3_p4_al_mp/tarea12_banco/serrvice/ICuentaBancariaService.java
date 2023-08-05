package com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
    public void agregar(CuentaBancaria cuentaBancaria);
    public String agregar2(CuentaBancaria cuentaBancaria);
    public void actulizar(CuentaBancaria cuentaBancaria);
    public void remover(String id);
    public CuentaBancaria buscarPorId(String id);
    public CuentaBancaria buscarPorNumCuentaBancaria(String id);

}
