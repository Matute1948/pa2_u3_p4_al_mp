package com.example.pa2_u3_p4_al_mp.serrvice;

import java.util.List;

import com.example.pa2_u3_p4_al_mp.repository.modelo.Habitacion;
import com.example.pa2_u3_p4_al_mp.repository.modelo.Hotel;

public interface IHotelService {
    public List<Hotel> buscarInnerJoin();
    public List<Hotel> buscarRightJoin();
    public List<Habitacion> buscarOuterLeftJoin();
    public List<Hotel> buscarFullJoin();
    public List<Hotel> buscarWhereJoin();
    public List<Hotel> buscarFetchJoin();
    public void agregar(Hotel hotel);
}
