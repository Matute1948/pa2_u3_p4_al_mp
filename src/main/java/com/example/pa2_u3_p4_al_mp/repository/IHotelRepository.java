package com.example.pa2_u3_p4_al_mp.repository;

import java.util.List;

import com.example.pa2_u3_p4_al_mp.repository.modelo.Habitacion;
import com.example.pa2_u3_p4_al_mp.repository.modelo.Hotel;

public interface IHotelRepository {
    public List<Hotel> seleccionarInnerJoin();
    public List<Hotel> seleccionarRightJoin();
    public List<Habitacion> seleccionarHabitacionesOuterLeftJoin();
    public List<Hotel> seleccionarFullJoin();
    public List<Hotel> seleccionarWhereJoin();
}
