package com.name.parcialcompi.service;

import com.name.parcialcompi.DTO.SecurityReportDTO;
import com.name.parcialcompi.Model.Flight;
import com.name.parcialcompi.Model.SecurityReport;
import com.name.parcialcompi.repository.FlightRepository;
import com.name.parcialcompi.repository.SecurityReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SecurityReportService {

    @Autowired
    private SecurityReportRepository securityReportRepository;

    @Autowired
    private FlightRepository flightRepository;
    //Crear un fileSecurityReport
    public SecurityReport fileSecurityReport(SecurityReportDTO securityReportDTO) {
        Optional<Flight> flightOpt = flightRepository.findById(securityReportDTO.getFlightId());

        if (flightOpt.isEmpty()) {
            throw new RuntimeException("Flight not found");
        }

        SecurityReport report = new SecurityReport();
        report.setFlight(flightOpt.get());
        report.setReportedBy(securityReportDTO.getReportedBy());
        report.setDescription(securityReportDTO.getDescription());

        return securityReportRepository.save(report);
    }
    //Traer los unresolverReports

    public List<SecurityReport> getUnresolvedReports() {
        return securityReportRepository.findByIsResolvedFalse();
    }
    //Marcar como resuletos los resportes
    public SecurityReport resolveReport(UUID id) {
        SecurityReport report = securityReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        report.setResolved(true);
        return securityReportRepository.save(report);
    }
}
