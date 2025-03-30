package com.name.parcialcompi.repository;

import com.name.parcialcompi.Model.PrivateJet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrivateJetRepository extends JpaRepository<PrivateJet, UUID> {
}
