package com.example.tp1.Controller;


import com.example.tp1.Entity.Voiture;
import com.example.tp1.Service.VoitureServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/voiture")
public class VoitureRestController {
    @Autowired
    private VoitureServiceImp voitureServiceImp;

    @PostMapping("/save")
    public ResponseEntity<Voiture> createVoiture(Voiture voiture){
        try {
            voitureServiceImp.createVoiture(voiture);
            return new ResponseEntity<Voiture>(HttpStatus.CREATED);

        } catch (Exception e){
            return new ResponseEntity<Voiture>(voiture, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity <List<Voiture>> getVoiture(){
        try {
            voitureServiceImp.getAllVoiture();
            return new ResponseEntity<List<Voiture>>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Voiture>>(HttpStatus.NOT_FOUND);
        }
    }
}
