package com.example.tp1.Controller;


import com.example.tp1.Entity.Client;
import com.example.tp1.Entity.Modele;
import com.example.tp1.Service.ModeleServiceImp;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modele")
public class ModelRestController {
    @Autowired
    private ModeleServiceImp modeleServiceImp;

    @PostMapping("/save")
    public ResponseEntity<Modele> createModele(@RequestBody Modele modele){
        try {
            modeleServiceImp.createModele(modele);
            return new ResponseEntity<Modele>(modele, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<Modele>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Modele>> getAllModele(){
        try {
            List<Modele> modeles = modeleServiceImp.getAllModele();
            if (modeles.isEmpty()){
                return new ResponseEntity<List<Modele>>(HttpStatus.NO_CONTENT);
            } return new ResponseEntity<List<Modele>>(modeles,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity <List<Modele>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity <Modele> getModeleByID(@PathVariable("id") Long id) {

            Modele modele = modeleServiceImp.getModeleById(id);
            if (modele != null) {
                return new ResponseEntity<Modele>(modele,HttpStatus.OK);
            } else {
                return new ResponseEntity <Modele>(HttpStatus.NOT_FOUND);
            }
    }

    @PutMapping("/update/{id}")
    public  Modele updateModele(@PathVariable("id")Long id,@RequestBody Modele modele){
        Modele m1= modeleServiceImp.getModeleById(id);
        if (m1 != null){
            modele.setId(id);
            return modeleServiceImp.updateModele(modele);
        } else {
            throw new RuntimeException(" can't update modele");
        }
    }


    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Modele> deleteModele(@PathVariable("id") Long id){
        modeleServiceImp.deleteModele(id);
        return new ResponseEntity<Modele>(HttpStatus.OK);
    }




}
