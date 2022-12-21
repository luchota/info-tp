package com.example.apirest.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "norecurrentes")
public class Norecurrentes {
    private @Id @GeneratedValue @Column(name  = "id_No_recurrente")Long id;
    private String code;

    @Column(name = "nombre")
    private String name;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "id_org")
    Organizacion organizacion;

    public Norecurrentes() {
    }

    public Norecurrentes(Long id, String code, String name, Date date, Boolean active) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.date = date;
        this.active = active;
    }

    public void update(Norecurrentes norecurrentes) {
        this.id = norecurrentes.getId();
        this.code = norecurrentes.getCode();
        this.name = norecurrentes.getName();
        this.date = norecurrentes.getDate();
        this.active = norecurrentes.getActive();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Norecurrentes{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", active=" + active +
                ", organizacion=" + organizacion +
                '}';
    }
}
