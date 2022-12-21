package com.example.apirest.models;

import javax.persistence.*;

@Entity
@Table(name = "turnos")
public class Turnos {
    private @Id @GeneratedValue @Column(name = "id_TURNOS") Long  id;
    @OneToOne private Recurrentes recurrente;
    @OneToOne private Norecurrentes norecurrentes;

    public Turnos() {
    }

    public Turnos(Long id, Recurrentes recurrente, Norecurrentes norecurrentes) {
        this.id = id;
        this.recurrente = recurrente;
        this.norecurrentes = norecurrentes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recurrentes getRecurrente() {
        return recurrente;
    }

    public void setRecurrente(Recurrentes recurrente) {
        this.recurrente = recurrente;
    }

    public Norecurrentes getNorecurrentes() {
        return norecurrentes;
    }

    public void setNorecurrentes(Norecurrentes norecurrentes) {
        this.norecurrentes = norecurrentes;
    }
}
