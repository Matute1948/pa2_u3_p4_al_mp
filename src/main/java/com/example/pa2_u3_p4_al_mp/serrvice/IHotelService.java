package com.example.pa2_u3_p4_al_mp.serrvice;

import java.util.List;

import com.example.pa2_u3_p4_al_mp.repository.modelo.Hotel;

public interface IHotelService {
    public List<Hotel> buscarInnerJoin();
}
