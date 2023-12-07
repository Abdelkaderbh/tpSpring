package com.example.tp1.Service;

import com.example.tp1.Entity.Modele;

import java.util.List;



public interface ModeleSetvice{
    Modele getModeleByModele_Name(String Modele_Name);
    List<Modele> getAllModele();

    Modele createModele(Modele modele);

    Modele getModeleById(Long id);
    Modele updateModele(Modele modele);
    void deleteModele(Long id);

}
