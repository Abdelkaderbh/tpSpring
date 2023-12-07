package com.example.tp1.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Serie")
    private String Serie;

    @Column(name = "Date_Mise_en")
    private String Date_Mise_en;


    @Column(name = "Modele_Nm")
    private String Modele_Nm;


    @JsonIgnore
    @OneToMany(mappedBy = "voiture")
    private List<Location> locations = new ArrayList<Location>();

    @ManyToOne
    @JoinColumn(name = "modele_id")
    private Modele modeleEntity;

    public Long getId() {
        return id;
    }

    public String getSerie() {
        return Serie;
    }

    public String getDate_Mise_en() {
        return Date_Mise_en;
    }

    public String getModele_Nm() {
        return Modele_Nm;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Modele getModeleEntity() {
        return modeleEntity;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setSerie(String serie) {
        Serie = serie;
    }

    public void setDate_Mise_en(String date_Mise_en) {
        Date_Mise_en = date_Mise_en;
    }

    public void setModele_Nm(String modele_Nm) {
        Modele_Nm = modele_Nm;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public void setModeleEntity(Modele modeleEntity) {
        this.modeleEntity = modeleEntity;
    }
}


