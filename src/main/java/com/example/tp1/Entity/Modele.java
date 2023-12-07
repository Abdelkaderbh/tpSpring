package com.example.tp1.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Model_Name")
    private String Model_Name;

    public Long getId() {
        return id;
    }

    public String getModel_Name() {
        return Model_Name;
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel_Name(String model_Name) {
        Model_Name = model_Name;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }


    @JsonIgnore
    @OneToMany(mappedBy = "modeleEntity",cascade = CascadeType.REMOVE)
    private List<Voiture> voitures=new ArrayList<>();

}
