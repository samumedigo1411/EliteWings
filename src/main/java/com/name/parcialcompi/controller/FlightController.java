package com.name.parcialcompi.controller;

import com.name.parcialcompi.DTO.FlightDTO;
import com.name.parcialcompi.Model.Flight;
import com.name.parcialcompi.service.FlightService;
import com.name.parcialcompi.service.PrivateJetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private PrivateJetService privateJetService;

    // Obtener un vuelo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable UUID id) {
        Optional<Flight> flight = flightService.getFlightById(id);
        return flight.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un vuelo (no una celebridad)
    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody FlightDTO flightDTO) {
        Flight flight = flightService.createFlight(flightDTO);
        if (flight == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(flight);
    }

    // Eliminar un vuelo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable UUID id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}
