package com.example.pa2_u3_p4_al_mp.serrvice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.repository.IHotelRepository;
import com.example.pa2_u3_p4_al_mp.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{

    @Autowired
    private IHotelRepository iHotelRepository;
    @Override
    public List<Hotel> buscarInnerJoin() {

        return this.iHotelRepository.seleccionarInnerJoin();

    }
    
}
