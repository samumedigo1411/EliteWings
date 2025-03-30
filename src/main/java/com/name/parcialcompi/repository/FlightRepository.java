package com.name.parcialcompi.repository;

import com.name.parcialcompi.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FlightRepository  extends JpaRepository<Flight, UUID> {

    List<Flight> findByPurpose(Flight.FlightPurpose purpose);
}
