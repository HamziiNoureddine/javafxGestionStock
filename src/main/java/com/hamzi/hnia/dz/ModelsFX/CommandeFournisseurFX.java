package com.hamzi.hnia.dz.ModelsFX;

import com.hamzi.hnia.dz.Models.CommandeClient;
import com.hamzi.hnia.dz.Models.CommandeFournisseur;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.format.DateTimeFormatter;

public class CommandeFournisseurFX {
    private SimpleLongProperty id;

    private SimpleStringProperty numeroCommande;
    // Ex: "VENTE-2023-001"
    private SimpleStringProperty date;

    private SimpleStringProperty fournisseur;

    private SimpleStringProperty adresseFournisseur;

    private SimpleStringProperty tel;

    private SimpleStringProperty email;

    public CommandeFournisseurFX(CommandeFournisseur cf) {

        this.id = new SimpleLongProperty(cf.getId());
        this.numeroCommande = new SimpleStringProperty(cf.getNumeroCommande());
        this.date = new SimpleStringProperty(cf.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.fournisseur = new SimpleStringProperty(cf.getFournisseur().getNom());
        this.adresseFournisseur =   new SimpleStringProperty(cf.getFournisseur().getAdresse());
        this.tel =  new SimpleStringProperty(cf.getFournisseur().getTelephone());
        this.email =  new SimpleStringProperty(cf.getFournisseur().getEmail());
    }


    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getNumeroCommande() {
        return numeroCommande.get();
    }

    public SimpleStringProperty numeroCommandeProperty() {
        return numeroCommande;
    }

    public void setNumeroCommande(String numeroCommande) {
        this.numeroCommande.set(numeroCommande);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getFournisseur() {
        return fournisseur.get();
    }

    public SimpleStringProperty fournisseurProperty() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur.set(fournisseur);
    }

    public String getAdresseFournisseur() {
        return adresseFournisseur.get();
    }

    public SimpleStringProperty adresseFournisseurProperty() {
        return adresseFournisseur;
    }

    public void setAdresseFournisseur(String adresseFournisseur) {
        this.adresseFournisseur.set(adresseFournisseur);
    }

    public String getTel() {
        return tel.get();
    }

    public SimpleStringProperty telProperty() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}
