package com.example.tp1.Service;

import com.example.tp1.Entity.Client;
import com.example.tp1.Repository.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class ClientServiceImp implements ClientService{
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client getClientByName(String nom) {
        return clientRepository.getClientByName(nom);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientByID(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
