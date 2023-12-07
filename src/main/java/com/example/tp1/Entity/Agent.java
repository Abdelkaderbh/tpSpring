package com.example.tp1.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom")
    private String nom;





}
