package com.name.parcialcompi.DTO;

import com.name.parcialcompi.Model.Flight;

import java.sql.Timestamp;
import java.util.UUID;

public class FlightDTO {
    private UUID celebrityId;
    private UUID jetId;
    private String departureAirport;
    private String arrivalAirport;
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    private Flight.FlightPurpose purpose;

    public UUID getCelebrityId() {
        return celebrityId;
    }

    public void setCelebrityId(UUID celebrityId) {
        this.celebrityId = celebrityId;
    }

    public UUID getJetId() {
        return jetId;
    }

    public void setJetId(UUID jetId) {
        this.jetId = jetId;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Flight.FlightPurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Flight.FlightPurpose purpose) {
        this.purpose = purpose;
    }
}
