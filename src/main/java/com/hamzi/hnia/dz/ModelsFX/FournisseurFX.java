package com.hamzi.hnia.dz.ModelsFX;

import com.hamzi.hnia.dz.Models.Fournisseur;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class FournisseurFX {

    private SimpleLongProperty id;

    private SimpleStringProperty nom;

    private SimpleStringProperty email;

    private SimpleStringProperty telephone;

    private SimpleStringProperty adresse;

    public FournisseurFX(Fournisseur fournisseur) {
      this.id = new SimpleLongProperty(fournisseur.getId());
      this.nom = new SimpleStringProperty(fournisseur.getNom());
      this.email = new SimpleStringProperty(fournisseur.getEmail());
      this.telephone = new SimpleStringProperty(fournisseur.getTelephone());
      this.adresse = new SimpleStringProperty(fournisseur.getAdresse());

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

    public String getNom() {
        return nom.get();
    }

    public SimpleStringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
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

    public String getTelephone() {
        return telephone.get();
    }

    public SimpleStringProperty telephoneProperty() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public String getAdresse() {
        return adresse.get();
    }

    public SimpleStringProperty adresseProperty() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }
}
