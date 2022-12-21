package com.example.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apirest.models.Recurrentes;

import java.util.List;

public interface RecurrentesRepo extends JpaRepository<Recurrentes, Long> {
    
}
