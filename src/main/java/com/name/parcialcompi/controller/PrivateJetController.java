package com.name.parcialcompi.controller;

import com.name.parcialcompi.DTO.PrivateJetDTO;
import com.name.parcialcompi.Model.Celebrity;
import com.name.parcialcompi.Model.PrivateJet;
import com.name.parcialcompi.service.CelebrityService;
import com.name.parcialcompi.service.PrivateJetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/jets")
public class PrivateJetController {

    @Autowired
    private PrivateJetService privateJetService;

    @Autowired
    private CelebrityService celebrityService;

    // Obtener un jet privado por ID
    @GetMapping("/{id}")
    public ResponseEntity<PrivateJet> getPrivateJetById(@PathVariable UUID id) {
        Optional<PrivateJet> privateJet = privateJetService.getPrivateJetById(id);
        return privateJet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo jet privado
    @PostMapping
    public ResponseEntity<PrivateJet> createPrivateJet(@RequestBody PrivateJetDTO privateJetDTO) {
        // Buscar el dueño (Celebrity) en la base de datos
        Optional<Celebrity> owner = celebrityService.getCelebrityById(privateJetDTO.getOwnerId());
        if (owner.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Mapear DTO a entidad
        PrivateJet privateJet = new PrivateJet();
        privateJet.setModel(privateJetDTO.getModel());
        privateJet.setCapacity(privateJetDTO.getCapacity());
        privateJet.setOwner(owner.get());

        return ResponseEntity.ok(privateJetService.createPrivateJet(privateJet));
    }

    // Actualizar un jet privado
    @PutMapping("/{id}")
    public ResponseEntity<PrivateJet> updatePrivateJet(@PathVariable UUID id,
                                                       @RequestBody PrivateJetDTO updatedPrivateJetDTO) {
        PrivateJet updated = privateJetService.updatePrivateJet(id, updatedPrivateJetDTO);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // Eliminar un jet privado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrivateJet(@PathVariable UUID id) {
        privateJetService.deletePrivateJet(id);
        return ResponseEntity.noContent().build();
    }
}
