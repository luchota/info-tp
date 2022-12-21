package com.example.apirest.controller;

import com.example.apirest.models.Organizacion;
import com.example.apirest.models.Personas;
import com.example.apirest.repositories.PersonasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("persona")
public class UsuarioController {
    @Autowired
    private final PersonasRepo personasRepo;

    public UsuarioController(PersonasRepo personasRepo) {
        this.personasRepo = personasRepo;
    }

    @PostMapping("")
    public Personas createPersona(@RequestBody Personas nuevaPersonas) {
        return personasRepo.save(nuevaPersonas);
    }

    @GetMapping("")
    public List<Personas> getAll() {
        return personasRepo.findAll();
    }

    @PutMapping("/update/{id}/{key}")
    public ResponseEntity<Personas> updatePersona(@PathVariable("id") Long id, @PathVariable("key") String key, @RequestBody Personas newPersona) {
        Optional<Personas> persona = personasRepo.findById(id);

        if (persona.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!persona.get().getKey().equals(key)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        Personas personaUpdated = persona.get();
        persona.get().update(newPersona);

        return new ResponseEntity<>(personasRepo.save(personaUpdated), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Organizacion> deletePersona(@PathVariable("id") Long id, @PathVariable("key") String key) {
        Optional<Personas> persona = personasRepo.findById(id);
        if (persona.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!persona.get().getKey().equals(key)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        personasRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{name}")
    public List<Personas> findByName(@PathVariable("name") String name) {
        return personasRepo.findByNameIs(name);
    }

    @GetMapping(value = "/apellido/{lastName}")
    public List<Personas> findByLastName(@PathVariable("lastName") String name) {
        return personasRepo.findByLastName(name);
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Personas> findByDni(@PathVariable("dni") Long dni) {
        Optional<Personas> personasOptional = personasRepo.findById(dni);

        if (personasOptional.isPresent()) {
            return new ResponseEntity<>(personasOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
