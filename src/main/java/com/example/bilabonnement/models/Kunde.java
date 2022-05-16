package com.example.bilabonnement.models;
// Forfatter @Cemakay Türker
public class Kunde {
    private String forNavn;
    private String efterNavn;
    private String adresse;
    private int postNummer;
    private String by;
    private String email;
    private int mobil;
    private int cpr_nr;
    private int kundeID;

    public Kunde(String forNavn, String efterNavn, String adresse, int postNummer, String by, String email, int mobil, int cpr_nr) {
        this.forNavn = forNavn;
        this.efterNavn = efterNavn;
        this.adresse = adresse;
        this.postNummer = postNummer;
        this.by = by;
        this.email = email;
        this.mobil = mobil;
        this.cpr_nr = cpr_nr;
    }

    public String getForNavn() {
        return forNavn;
    }

    public void setForNavn(String forNavn) {
        this.forNavn = forNavn;
    }

    public String getEfterNavn() {
        return efterNavn;
    }

    public void setEfterNavn(String efterNavn) {
        this.efterNavn = efterNavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPostNummer() {
        return postNummer;
    }

    public void setPostNummer(int postNummer) {
        this.postNummer = postNummer;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobil() {
        return mobil;
    }

    public void setMobil(int mobil) {
        this.mobil = mobil;
    }

    public int getCpr_nr() {
        return cpr_nr;
    }

    public void setCpr_nr(int cpr_nr) {
        this.cpr_nr = cpr_nr;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "forNavn='" + forNavn + '\'' +
                ", efterNavn='" + efterNavn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", postNummer=" + postNummer +
                ", by='" + by + '\'' +
                ", email='" + email + '\'' +
                ", mobil=" + mobil +
                ", cpr_nr=" + cpr_nr +
                '}';
    }
}
