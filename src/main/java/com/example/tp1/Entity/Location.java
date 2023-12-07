package com.example.tp1.Entity;


import jakarta.persistence.*;

@Entity
public class Location {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


     @Column(name = "date_debut")
             private String date_debut;
    @Column(name = "date_retour")
            private String date_retour;

    @Column(name = "prix_jour")
            private Integer prix_jour;

    @Column(name="prix")
            private Integer prix;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "voiture_id")
    private Voiture voiture;

}
