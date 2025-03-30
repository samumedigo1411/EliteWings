package com.name.parcialcompi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name="celebrity_id")
    private Celebrity celebrity;
    @ManyToOne
    @JoinColumn(name="jet_id")
    private PrivateJet jet;
    @Column(nullable = false)
    private String departureAirport;
    @Column(nullable = false)
    private String arrivalAirport;
    @Column(nullable = false)
    private Timestamp departureTime;
    @Column(nullable = false)
    private Timestamp arrivalTime;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FlightPurpose purpose;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(Celebrity celebrity) {
        this.celebrity = celebrity;
    }

    public PrivateJet getJet() {
        return jet;
    }

    public void setJet(PrivateJet jet) {
        this.jet = jet;
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

    public FlightPurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(FlightPurpose purpose) {
        this.purpose = purpose;
    }

    public enum FlightPurpose {
        Bussines, Vacation, Suspicious

    }
}

