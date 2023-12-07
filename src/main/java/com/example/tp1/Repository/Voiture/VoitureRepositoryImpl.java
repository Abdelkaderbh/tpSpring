package com.example.tp1.Repository.Voiture;

import com.example.tp1.Entity.Voiture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class VoitureRepositoryImpl implements VoitureRepositoryCustum{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Voiture getVoitureByModele_Nm(String Modele_Nm) {
        Query query=entityManager.createNativeQuery("select v.* from Voiture v"+"Where v.Modele_Nm LIKE ?",Voiture.class);
        query.setParameter(1,Modele_Nm+"%");
        return (Voiture) query.getSingleResult();
    }
}
