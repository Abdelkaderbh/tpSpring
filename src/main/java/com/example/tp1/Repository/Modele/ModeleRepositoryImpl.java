package com.example.tp1.Repository.Modele;

import com.example.tp1.Entity.Modele;
import com.example.tp1.Entity.Voiture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class ModeleRepositoryImpl implements ModeleRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Modele getModeleByModele_Name(String Modele_Name) {
        Query query = entityManager.createNativeQuery("select m.* from Modele"+"Where m.Modele_Name Like ?", Modele.class);
        query.setParameter("1",Modele_Name+"%");
        return (Modele) query.getSingleResult();
    }

}
