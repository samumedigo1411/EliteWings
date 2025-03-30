package com.name.parcialcompi.service;

import com.name.parcialcompi.DTO.FlightDTO;
import com.name.parcialcompi.Model.Flight;
import com.name.parcialcompi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FlightService {

    @Autowired
    public FlightRepository flightRepository;
    // Crear un vuelo a partir de un DTO
    public Flight createFlight(FlightDTO flightDTO) {
        Flight flight = new Flight();
        flight.setArrivalAirport(flightDTO.getArrivalAirport());
        flight.setDepartureTime(flightDTO.getDepartureTime());
        flight.setPurpose(flightDTO.getPurpose());
        return flightRepository.save(flight);
    }
    //Buscar un flight por ID
    public Optional<Flight> getFlightById(UUID id){
        return flightRepository.findById(id);
    }
    //Buscar un avion sospechoso
    public List<Flight> getSuspiciousFlights(){
        return flightRepository.findByPurpose(Flight.FlightPurpose.Suspicious);
    }
    //Cancelar un vuelo
    public void deleteFlight(UUID id){
        flightRepository.deleteById(id);
    }
}
