package com.example.pa2_u3_p4_al_mp.tarea12_banco.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.Transferencia;

public interface ITransferenciaRepository {
    public void insertar(Transferencia transferencia);
    public void actulizar(Transferencia transferencia);
    public void eliminar(String id);
    public Transferencia seleccionarPorId(String id);
    public void realizarTransferencia(String numCtaOrigen,String numCtaDestino,BigDecimal monto);
    public List<Transferencia> seleccionarTodo();
}
