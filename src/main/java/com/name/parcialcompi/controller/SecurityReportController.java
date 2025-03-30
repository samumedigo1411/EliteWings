package com.name.parcialcompi.controller;

import com.name.parcialcompi.DTO.SecurityReportDTO;
import com.name.parcialcompi.Model.SecurityReport;
import com.name.parcialcompi.service.SecurityReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/securityreport")
public class SecurityReportController {

    @Autowired
    private SecurityReportService securityReportService;

    //Crear el fileSecurityReport
    @PostMapping
    public ResponseEntity<SecurityReport> fileSecurityReport(@RequestBody SecurityReportDTO securityReportDTO) {
        SecurityReport report = securityReportService.fileSecurityReport(securityReportDTO);
        return ResponseEntity.ok(report);
    }

    //Traer los unresolverdResports
    @GetMapping("/unresolved")
    public ResponseEntity<List<SecurityReport>> getUnresolvedReports() {
        List<SecurityReport> reports = securityReportService.getUnresolvedReports();
        return ResponseEntity.ok(reports);
    }

    //Marcar como resuleto los resportes por un id
    @PatchMapping("/{id}/resolve")
    public ResponseEntity<SecurityReport> resolveReport(@PathVariable UUID id) {
        SecurityReport resolvedReport = securityReportService.resolveReport(id);
        return ResponseEntity.ok(resolvedReport);
    }
}
