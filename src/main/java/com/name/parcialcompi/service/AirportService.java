package com.name.parcialcompi.service;

import com.name.parcialcompi.Model.Airport;
import com.name.parcialcompi.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;
    //Buscar por ID
    public Optional<Airport> getAiportById(UUID id){
        return airportRepository.findById(id);
    }
    //Busca todos los aeropuertos
    public List<Airport> getAllAirports(){
        return airportRepository.findAll();
    }
}
