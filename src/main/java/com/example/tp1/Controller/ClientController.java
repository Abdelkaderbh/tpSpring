package com.example.tp1.Controller;


import com.example.tp1.Entity.Client;
import com.example.tp1.Entity.Voiture;
import com.example.tp1.Service.ClientServiceImp;
import com.example.tp1.Service.VoitureServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientServiceImp clientServiceImp;
    @Autowired
    private VoitureServiceImp voitureServiceImp;

    @RequestMapping("/addClient")
    public String addClient (Model model){
        Client client = new Client();
        model.addAttribute("ClientForm",client);
        return "new_client";
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("ClientForm")Client client){
        clientServiceImp.createClient(client);
        return "redirect:/";
    }

    @RequestMapping("/")
    public String listClients(Model model){
        List<Client> listClients = clientServiceImp.getAllClient();
        List<Voiture> listVoitures = voitureServiceImp.getAllVoiture();
        model.addAttribute("listClients",listClients);
        model.addAttribute("listVoitures",listVoitures);
        return "liste_clients";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id ,Model model){
        Client client = clientServiceImp.getClientByID(id);
        model.addAttribute("client",client);
        return "update_client";
    }

    @PostMapping("update/{id}")
    public String updateClient(@PathVariable("id") long id , @Validated Client client,BindingResult result,Model model){
        if (result.hasErrors()){
            client.setId(id);
            return "update_client";
        }
        clientServiceImp.createClient(client);
        model.addAttribute("listClients",clientServiceImp.getAllClient());
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteClient(@PathVariable("id") long id ,Model model){
        clientServiceImp.deleteClient(id);
        model.addAttribute("listClients",clientServiceImp.getAllClient());
        return "redirect:/";
    }

}
