package com.example.bilabonnement.controller;

import com.example.bilabonnement.service.PersonaleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@Controller
public class PersonaleController {

    private final PersonaleService personaleService = new PersonaleService();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String logInd(WebRequest personaleData,HttpServletRequest request) {
        String brugernavn = personaleData.getParameter("brugernavn");
        String password = personaleData.getParameter("password");
        boolean token = personaleService.checkBruger(brugernavn, password);
        if (token) {
            String rolle = personaleService.getRolle(brugernavn, password);
            HttpSession session = request.getSession();;
            session.setAttribute("isloggedin", "cem");
            session.getId();

            if (rolle.equals("DR")) {
                return "redirect:http://localhost:8080/Dataregistrering/Invalid";
            }
            if (rolle.equals("FU")) {
                return "redirect:http://localhost:8080/Forretningsudvikling";
            }
            if (rolle.equals("S&U")) {
                return "redirect:http://localhost:8080/SkadeOgUdbedring/Biler-med-skader";
            }
        }
        return "redirect:http://localhost:8080/";
    }




    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("brugernavn");
        return "redirect:/";
    }




}
