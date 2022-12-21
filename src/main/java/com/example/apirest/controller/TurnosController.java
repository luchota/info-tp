package com.example.apirest.controller;

import com.example.apirest.models.Norecurrentes;
import com.example.apirest.repositories.NoRecurrenteRepo;
import com.example.apirest.repositories.Result;
import com.example.apirest.repositories.TurnosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("turnos")
public class TurnosController {

    @Autowired
    private final TurnosRepo turnosRepo;

    @Autowired
    private final NoRecurrenteRepo noRecurrenteRepo;

    public TurnosController(TurnosRepo turnosRepo, NoRecurrenteRepo noRecurrenteRepo) {
        this.turnosRepo = turnosRepo;
        this.noRecurrenteRepo = noRecurrenteRepo;
    }

    @PostMapping("")
    public ResponseEntity<Norecurrentes> createTurno(@RequestBody Norecurrentes turno) {;
        return new ResponseEntity<>(noRecurrenteRepo.save(turno), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Norecurrentes> updateTurno(@PathVariable("id") Long id, @RequestBody Norecurrentes turnos) {
        Optional<Norecurrentes> noRecurrentes = noRecurrenteRepo.findById(id);

        if (noRecurrentes.isPresent()) {
            Norecurrentes norecurrentesUpdated = noRecurrentes.get();
            norecurrentesUpdated.update(turnos);
            return new ResponseEntity<>(noRecurrenteRepo.save(norecurrentesUpdated), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTurno(@PathVariable Long id) {
        noRecurrenteRepo.deleteById(id);
    }

    @GetMapping("/norecurrentes/{orgName}")
    public Collection<Result> getNoRecurrenteByOrgName(@PathVariable("orgName") String orgName) {
        System.out.println(turnosRepo.orgName(orgName).toString());
        return turnosRepo.orgName(orgName);
    }

    @GetMapping("/norecurrentes/{orgName}/{eventName}")
    public Collection<Result> getNoRecurrenteByOrgName(@PathVariable("orgName") String orgName, @PathVariable("eventName") String eventName) {
        System.out.println(turnosRepo.orgName(orgName).toString());
        return turnosRepo.orgName1(orgName, eventName);
    }


}
