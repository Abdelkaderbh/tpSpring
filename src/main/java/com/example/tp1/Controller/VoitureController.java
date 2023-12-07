package com.example.tp1.Controller;


import com.example.tp1.Entity.Modele;
import com.example.tp1.Entity.Voiture;
import com.example.tp1.Service.ModeleServiceImp;
import com.example.tp1.Service.VoitureServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VoitureController {
    @Autowired
    private VoitureServiceImp voitureServiceImp;
    @Autowired
    private ModeleServiceImp modeleServiceImp;



    @RequestMapping("/addVoiture")
    public String addVoiture(Model model){
        Voiture voiture = new Voiture();
        List<Modele>list=modeleServiceImp.getAllModele();
        model.addAttribute("VoitureForm",voiture);
        model.addAttribute("listemodel",list);
        return "new_voiture";
    }

    @RequestMapping(value = "/addVoiture/save",method = RequestMethod.POST)
    public String saveVoiture(@ModelAttribute("VoitureForm")Voiture voiture){
        voitureServiceImp.createVoiture(voiture);
        return "redirect:/";
    }

    @GetMapping("/delete/voiture/{id}")
    public String deleteVoiture(@PathVariable("id")Long id,Model model){
        voitureServiceImp.deleteVoiture(id);
        model.addAttribute("listVoitures",voitureServiceImp.getAllVoiture());
        return "redirect:/";
    }


    @GetMapping("edit/voiture/{id}")
    public String showUpdateForm(@PathVariable("id") long id ,Model model){
        Voiture voiture = voitureServiceImp.getVoitureById(id);
        model.addAttribute("Voiture",voiture);
        return "update_voiture";
    }

    @PostMapping("update/voiture/{id}")
    public String updateVoiture(@PathVariable("id") long id , @Validated Voiture voiture, BindingResult result, Model model){
        if (result.hasErrors()){
            voiture.setId(id);
            return "update_voiture";
        }
        voitureServiceImp.createVoiture(voiture);
        model.addAttribute("listVoitures",voitureServiceImp.getAllVoiture());
        return "redirect:/";
    }





}
