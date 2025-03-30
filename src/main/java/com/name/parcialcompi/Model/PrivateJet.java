package com.name.parcialcompi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PrivateJet {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private int capacity;
    @ManyToOne
    @JoinColumn(name="owner_id",nullable = false)
    private Celebrity owner;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Celebrity getOwner() {
        return owner;
    }

    public void setOwner(Celebrity owner) {
        this.owner = owner;
    }
}
