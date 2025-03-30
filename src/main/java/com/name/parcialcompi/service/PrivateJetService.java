package com.name.parcialcompi.service;

import com.name.parcialcompi.DTO.PrivateJetDTO;
import com.name.parcialcompi.Model.Celebrity;
import com.name.parcialcompi.Model.PrivateJet;
import com.name.parcialcompi.repository.PrivateJetRepository;
import com.name.parcialcompi.repository.CelebrityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PrivateJetService {

    @Autowired
    private PrivateJetRepository privateJetRepository;

    @Autowired
    private CelebrityInterface celebrityRepository;

    // Crear un jet privado
    public PrivateJet createPrivateJet(PrivateJet privateJet) {
        return privateJetRepository.save(privateJet);
    }

    // Buscar un jet por ID
    public Optional<PrivateJet> getPrivateJetById(UUID id) {
        return privateJetRepository.findById(id);
    }

    // Editar un jet privado
    public PrivateJet updatePrivateJet(UUID id, PrivateJetDTO updatedPrivateJetDTO) {
        return privateJetRepository.findById(id).map(privateJet -> {
            privateJet.setModel(updatedPrivateJetDTO.getModel());
            privateJet.setCapacity(updatedPrivateJetDTO.getCapacity());

            if (updatedPrivateJetDTO.getOwnerId() != null) {
                Optional<Celebrity> owner = celebrityRepository.findById(updatedPrivateJetDTO.getOwnerId());
                if (owner.isPresent()) {
                    privateJet.setOwner(owner.get());
                } else {
                    return null; // No se encontró el dueño
                }
            }

            return privateJetRepository.save(privateJet);
        }).orElse(null);
    }

    // Eliminar un jet privado
    public void deletePrivateJet(UUID id) {
        privateJetRepository.deleteById(id);
    }
}
