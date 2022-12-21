package com.example.apirest.controller;

import com.example.apirest.models.Norecurrentes;
import com.example.apirest.models.Organizacion;
import com.example.apirest.repositories.OrganizacionRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("org")
public class OrganizacionController {
    private final OrganizacionRepo orgRepo;

    public OrganizacionController(OrganizacionRepo orgRepo) {
        this.orgRepo = orgRepo;
    }

    @PostMapping("")
    public ResponseEntity<Organizacion> createOrganization(@RequestBody Organizacion org) {
        return new ResponseEntity<>(orgRepo.save(org), HttpStatus.OK);
    }

    @GetMapping("")
    public List<Organizacion> getAll() {
        return orgRepo.findAll();
    }

    @PutMapping("/update/{id}/{key}")
    public ResponseEntity<Organizacion> updateOrganization(@PathVariable("id") Long id, @PathVariable("key") String key, @RequestBody Organizacion newOrg) {
        Optional<Organizacion> org = orgRepo.findById(id);

        if (org.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!org.get().getCode().equals(key)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        Organizacion orgUpdated = org.get();
        org.get().update(newOrg);

        return new ResponseEntity<>(orgRepo.save(orgUpdated), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Organizacion> deleteOrganization(@PathVariable("id") Long id, @PathVariable("key") String key) {
        Optional<Organizacion> org = orgRepo.findById(id);
        if (org.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!org.get().getCode().equals(key)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        orgRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{cuit}")
    public ResponseEntity<Organizacion> findByCuit(@PathVariable("cuit") long cuit) {
        Optional<Organizacion> organizacionOptional = orgRepo.findById(cuit);
        if (organizacionOptional.isPresent()) {
            return new ResponseEntity<>(organizacionOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Organizacion> findByName(@PathVariable("name") long name) {
        Optional<Organizacion> organizacionOptional = orgRepo.findById(name);
        if (organizacionOptional.isPresent()) {
            return new ResponseEntity<>(organizacionOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

