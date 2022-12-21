package com.example.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apirest.models.Norecurrentes;

public interface NoRecurrenteRepo extends JpaRepository<Norecurrentes, Long> {
    
}
