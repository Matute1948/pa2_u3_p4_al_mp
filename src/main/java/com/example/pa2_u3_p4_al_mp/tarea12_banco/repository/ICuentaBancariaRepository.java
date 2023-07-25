package com.example.pa2_u3_p4_al_mp.tarea12_banco.repository;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
    public void insertar(CuentaBancaria cuentaBancaria);
    public void actulizar(CuentaBancaria cuentaBancaria);
    public void eliminar(String id);
    public CuentaBancaria seleccionarPorId(String id);
    public CuentaBancaria seleccionarPorNumerp(String numCta);
}
