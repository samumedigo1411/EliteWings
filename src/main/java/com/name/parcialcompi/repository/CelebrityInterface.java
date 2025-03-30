package com.name.parcialcompi.repository;

import com.name.parcialcompi.Model.Celebrity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CelebrityInterface extends JpaRepository<Celebrity, UUID> {
}
