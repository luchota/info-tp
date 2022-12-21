package com.example.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apirest.models.Personas;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonasRepo extends JpaRepository<Personas, Long>{

    List<Personas> findByLastName(String lastName);

    List<Personas> findByNameIs(String name);

    Personas findByDni(int dni);
}
