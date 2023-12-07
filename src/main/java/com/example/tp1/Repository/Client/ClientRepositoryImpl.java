package com.example.tp1.Repository.Client;

import com.example.tp1.Entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class ClientRepositoryImpl implements ClientRepositoryCustum {

    @PersistenceContext
    private EntityManager entityManager;
    public Client getClientByName(String nom){
        Query query = entityManager.createNativeQuery("SELECT c.* FROM Client c"+"WHERE c.nom LIKE ?",Client.class);
        query.setParameter(1,nom+"%");
        return (Client) query.getSingleResult();
    }

}
