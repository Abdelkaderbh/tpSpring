package com.example.tp1.Service;

import com.example.tp1.Entity.Modele;
import com.example.tp1.Repository.Modele.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeleServiceImp implements ModeleSetvice{
    @Autowired
    private ModeleRepository modeleRepository;
    @Override
    public Modele getModeleByModele_Name(String Modele_Name) {
        return null;
    }

    @Override
    public List<Modele> getAllModele() {
        return modeleRepository.findAll();
    }

    @Override
    public Modele createModele(Modele modele) {
       return modeleRepository.save(modele);
    }

    @Override
    public Modele getModeleById(Long id) {
        return modeleRepository.findById(id).get();
    }

    @Override
    public Modele updateModele(Modele modele) {
        return modeleRepository.saveAndFlush(modele);
    }

    @Override
    public void deleteModele(Long id) {
        modeleRepository.deleteById(id);
    }
}
