package com.example.tp1.Service;

import com.example.tp1.Entity.Voiture;
import com.example.tp1.Repository.Voiture.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class VoitureServiceImp implements VoitureService{
    @Autowired
    private VoitureRepository voitureRepository;
    @Override
    public Voiture getVoitureByModele_Nm(String Modele_Nm) {
        return voitureRepository.getVoitureByModele_Nm(Modele_Nm);
    }

    @Override
    public List<Voiture> getAllVoiture() {
        return voitureRepository.findAll();
    }

    @Override
    public Voiture createVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    @Override
    public Voiture getVoitureById(Long id) {
        return voitureRepository.findById(id).get();
    }

    @Override
    public Voiture updateVoiture(Voiture voiture) {
        return voitureRepository.saveAndFlush(voiture);
    }

    @Override
    public void deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
    }
}
