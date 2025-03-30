package com.name.parcialcompi.controller;

import com.name.parcialcompi.DTO.CelebrityDTO;
import com.name.parcialcompi.Model.Celebrity;
import com.name.parcialcompi.service.CelebrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/celebrities")
public class CelebrityController {

    @Autowired
    private CelebrityService celebrityService;

    // Obtener una celebridad por ID
    @GetMapping("/{id}")
    public ResponseEntity<Celebrity> getCelebrityById(@PathVariable UUID id) {
        Optional<Celebrity> celebrity = celebrityService.getCelebrityById(id);
        return celebrity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una celebridad
    @PostMapping
    public ResponseEntity<Celebrity> createCelebrity(@RequestBody CelebrityDTO celebrityDTO) {
        Celebrity celebrity = new Celebrity();
        celebrity.setName(celebrityDTO.getName());
        celebrity.setProfession(celebrityDTO.getProfession());
        celebrity.setNetWorth(celebrityDTO.getNetWorth());
        celebrity.setSuspiciousActivity(celebrityDTO.isSuspiciousActivity());

        return ResponseEntity.ok(celebrityService.createCelebrity(celebrity));
    }

    // Actualizar una celebridad
    public ResponseEntity<Celebrity> updateCelebrity(@PathVariable UUID id, @RequestBody CelebrityDTO updatedCelebrityDTO) {
        Celebrity updated = celebrityService.updateCelebrity(id, updatedCelebrityDTO);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // Eliminar una celebridad
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCelebrity(@PathVariable UUID id) {
        celebrityService.deleteCelebrity(id);
        return ResponseEntity.noContent().build();
    }
}
