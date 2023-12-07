package com.example.tp1.Service;

import com.example.tp1.Entity.Voiture;

import java.util.List;

public interface VoitureService {
    Voiture getVoitureByModele_Nm(String Modele_Nm);
    List<Voiture> getAllVoiture();
    Voiture createVoiture(Voiture voiture);
    Voiture getVoitureById(Long id);

    Voiture updateVoiture(Voiture voiture);

    void deleteVoiture(Long id);
}
