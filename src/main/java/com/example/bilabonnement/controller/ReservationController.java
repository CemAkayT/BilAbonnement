package com.example.bilabonnement.controller;

import com.example.bilabonnement.models.Reservation;
import com.example.bilabonnement.service.BilService;
import com.example.bilabonnement.service.KundeService;
import com.example.bilabonnement.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationController {

    //TODO GENERELT tilføj SQL syntax til at ændre i databasen


    private final ReservationService reservationService = new ReservationService();
    private final BilService bilService = new BilService();
    private final KundeService kundeService = new KundeService();

    @GetMapping("/Dataregistrering")
    public String ShowValidReservationer(){
        reservationService.createValidReservationList();

        return "Dataregistrering";
    }
    @GetMapping("/Dataregistrering/Invalid")
    public String ShowInvalidReservationer(){
        reservationService.createInvalidReservationList();

        return "Dataregistrering";
    }

    @PostMapping("/Dataregistrering")
    public String ændreValidation(@ModelAttribute(name = "reservation") Reservation reservation, Model model){
        int bilID = reservation.getBilID();
        int kundeID = reservation.getKundeID();
        model.addAttribute("bilID",bilID);
        model.addAttribute("kundeID",kundeID);
        reservationService.ændreValidationReservation(reservationService.getReservation(bilID,kundeID));
        return "Dataregistrering";
    }

    //TODO get method til at vise all info på reservation

    @GetMapping("/Dataregistrering/info")
    public String showReservationInfo(@ModelAttribute(name = "reservation") Reservation reservation, Model model1, Model model2){
        model1.addAttribute("bil",bilService.getBil(reservation.getBilID()));
        model2.addAttribute("kunde",kundeService.getKunde(reservation.getKundeID()));

        return "Dataregistrering";
    }

}
