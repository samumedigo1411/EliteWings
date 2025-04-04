package com.name.parcialcompi.repository;

import com.name.parcialcompi.Model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AirportRepository extends JpaRepository<Airport, UUID> {
}
