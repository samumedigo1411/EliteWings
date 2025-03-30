package com.name.parcialcompi.controller;

import com.name.parcialcompi.Model.Airport;
import com.name.parcialcompi.service.AirportService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/airport")
public class AiporContreoller {
    @Autowired
    private AirportService airportService;
    //Buscar airport por id
    @GetMapping("/{id}")
    public ResponseEntity<Airport>getAirportById(@PathVariable UUID id){
        Optional<Airport> airport=airportService.getAiportById(id);
        return airport.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    //Traer todos los airports
    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports() {
        return ResponseEntity.ok(airportService.getAllAirports());
    }
}
