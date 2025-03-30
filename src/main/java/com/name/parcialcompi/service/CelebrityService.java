package com.name.parcialcompi.service;

import com.name.parcialcompi.DTO.CelebrityDTO;
import com.name.parcialcompi.Model.Celebrity;
import com.name.parcialcompi.repository.CelebrityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CelebrityService {

    @Autowired
    private CelebrityInterface celebrityInterface;

    // Crear una celebridad
    public Celebrity createCelebrity(Celebrity celebrity) {

        return celebrityInterface.save(celebrity);
    }

    // Buscar una celebridad por ID
    public Optional<Celebrity> getCelebrityById(UUID id) {

        return celebrityInterface.findById(id);
    }

    // Editar una celebridad
    public Celebrity updateCelebrity(UUID id, CelebrityDTO updatedCelebrityDTO) {
        return celebrityInterface.findById(id).map(celebrity -> {
            celebrity.setName(updatedCelebrityDTO.getName());
            celebrity.setProfession(updatedCelebrityDTO.getProfession());
            celebrity.setNetWorth(updatedCelebrityDTO.getNetWorth());
            celebrity.setSuspiciousActivity(updatedCelebrityDTO.isSuspiciousActivity());
            return celebrityInterface.save(celebrity);
        }).orElse(null);
    }


    // Eliminar una celebridad
    public void deleteCelebrity(UUID id) {
        celebrityInterface.deleteById(id);
    }
}
