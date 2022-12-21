package com.example.apirest.models;

import javax.persistence.*;


@Entity
@Table(name = "personas")
public class Personas {
    private @Id @GeneratedValue Long id;

    @Column(name = "nombre")
    private String name;
    private Long dni;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "llave")
    private String key;

    public Personas(){}
    public Personas(Long id, String name, String lastname, Long dni, String key){
        this.name=name;
        this.id=id;
        this.lastName=lastname;
        this.dni=dni;
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void update(Personas newPersona) {
        this.name = newPersona.getName();
        this.id = newPersona.getId();
        this.lastName = newPersona.getLastName();
        this.dni = newPersona.getDni();
        this.key = newPersona.getKey();
    }
}
