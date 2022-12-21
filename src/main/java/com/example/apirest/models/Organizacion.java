package com.example.apirest.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "organizacion")
public class Organizacion {
    private @Id @GeneratedValue @Column(name = "id_org") Long id;

    @Column(name = "nombre_org")
    private String name;
    private long cuit;
    private String addres;
    private int phone;
    private String email;
    private Date fechaAlta;
    private String code;
    @OneToMany(mappedBy = "organizacion") private List<Recurrentes> recurrentes = new ArrayList<>();
    @OneToMany(mappedBy = "organizacion") private List<Norecurrentes> norecurrentes = new ArrayList<>();

    public Organizacion() {
    }

    public Organizacion(Long id, String name, int cuit, String addres, int phone, String email, Date fechaAlta, String code, Recurrentes recurrente) {
        this.id = id;
        this.name = name;
        this.cuit = cuit;
        this.addres = addres;
        this.phone = phone;
        this.email = email;
        this.fechaAlta = fechaAlta;
        this.code = code;
        this.recurrentes.add(recurrente);
    }

    public void update(Organizacion org) {
        this.id = org.getId();
        this.name = org.getName();
        this.cuit = org.getCuit();
        this.addres = org.getAddres();
        this.phone = org.getPhone();
        this.email = org.getEmail();
        this.fechaAlta = org.getFechaAlta();
        this.code = org.getCode();
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

    public long getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Recurrentes> getRecurrentes() {
        return recurrentes;
    }

    public void setRecurrentes(List<Recurrentes> recurrentes) {
        this.recurrentes = recurrentes;
    }

    public List<Norecurrentes> getNorecurrentes() {
        return norecurrentes;
    }

    public void setNorecurrentes(List<Norecurrentes> norecurrentes) {
        this.norecurrentes = norecurrentes;
    }
}
