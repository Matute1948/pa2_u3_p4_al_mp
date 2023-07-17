package com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice;

import java.math.BigDecimal;
import java.util.List;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.Transferencia;

public interface ITransferenciaService {
    public void agregar(Transferencia transferencia);
    public void actulizar(Transferencia transferencia);
    public void remover(String id);
    public Transferencia buscarPorId(String id);
    public void procesoTransferencia(String numCtaOrigen,String numCtaDestino,BigDecimal monto);
    public List<Transferencia> reporteTodoTransferencias();
}
