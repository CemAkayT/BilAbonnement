package com.example.bilabonnement.controller;

import com.example.bilabonnement.models.Personale;
import com.example.bilabonnement.service.PersonaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;


@Controller
public class PersonaleController {

    private final PersonaleService personaleService = new PersonaleService();

    @GetMapping("/")
    public String index(){return "index";}

    @PostMapping("/")
    public String LogInd(WebRequest personaleData) {
        String brugernavn = personaleData.getParameter("brugernavn");
        String password = personaleData.getParameter("password");
        boolean token = personaleService.checkBruger(brugernavn, password);
        if(token){
            String rolle = personaleService.getRolle(brugernavn, password);
            if(rolle.equals("DR")){return "redirect:/Dataregistrering/Invalid";}
            if(rolle.equals("FU")){return "redirect:Forretningsudviklere";}
            if(rolle.equals("S&U")){return "redirect:/Skade&Udebedring/Biler-med-skader";}
        }
        return "index";

        }


    //TODO method til at logge ud af system


    }
