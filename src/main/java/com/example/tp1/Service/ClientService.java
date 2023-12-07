package com.example.tp1.Service;

import com.example.tp1.Entity.Client;

import java.util.List;

public interface ClientService {
    Client getClientByName(String nom);
    List<Client> getAllClient();


    Client createClient(Client client);
    Client getClientByID(Long id);

    Client updateClient(Client client);

    void deleteClient(Long id);

}
