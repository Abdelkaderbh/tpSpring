package com.example.tp1.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cin")
    private Integer cin;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name="adresse")
    private String adresse;

    @JsonIgnore
    @OneToMany (mappedBy = "client",cascade = CascadeType.REMOVE)
    private List<Location> locations=new ArrayList<Location>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCin() {
        return cin;
    }

    public void setCin(Integer cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

//    public void setId(long id) {
//        this.id = id;
//    }
}
