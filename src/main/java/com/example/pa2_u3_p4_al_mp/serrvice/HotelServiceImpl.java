package com.example.pa2_u3_p4_al_mp.serrvice;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.repository.IHotelRepository;
import com.example.pa2_u3_p4_al_mp.repository.modelo.Habitacion;
import com.example.pa2_u3_p4_al_mp.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{

    @Autowired
    private IHotelRepository iHotelRepository;
    @Override
    public List<Hotel> buscarInnerJoin() {

        return this.iHotelRepository.seleccionarInnerJoin();

    }
    @Override
    public List<Hotel> buscarRightJoin() {
        return this.iHotelRepository.seleccionarRightJoin();
    }
    @Override
    public List<Habitacion> buscarOuterLeftJoin() {
        return iHotelRepository.seleccionarHabitacionesOuterLeftJoin();
    }
    @Override
    public List<Hotel> buscarFullJoin() {
        return this.iHotelRepository.seleccionarFullJoin();
    }
    @Override
    public List<Hotel> buscarWhereJoin() {
        return this.iHotelRepository.seleccionarWhereJoin();
    }
    @Override
    public List<Hotel> buscarFetchJoin() {
        return this.iHotelRepository.seleccionarFetchJoin();
    }
    @Override
    public void agregar(Hotel hotel) {
        for (Habitacion habitacion : hotel.getHabitacion()) {
            habitacion.setValorMasIVA(new BigDecimal(1.12));
            
        }
        this.iHotelRepository.insertar(hotel);
    }
    
}
