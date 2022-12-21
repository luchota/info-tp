package com.example.apirest.models;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "recurrentes")
public class Recurrentes {
    private @Id @GeneratedValue @Column(name= "id_Recurrentes") Long id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_org")
    Organizacion organizacion;

    public Recurrentes() {
    }

    public Recurrentes(Long id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
