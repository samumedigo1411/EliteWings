package com.name.parcialcompi.repository;

import com.name.parcialcompi.Model.SecurityReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SecurityReportRepository extends JpaRepository<SecurityReport, UUID> {
    List<SecurityReport> findByIsResolvedFalse();
}
