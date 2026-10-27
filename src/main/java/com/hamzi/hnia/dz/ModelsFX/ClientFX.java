package com.hamzi.hnia.dz.ModelsFX;

import com.hamzi.hnia.dz.Models.Client;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class ClientFX {
    private SimpleLongProperty id;

    private SimpleStringProperty nom;

    private SimpleStringProperty prenom;

    private SimpleStringProperty adresse;

    private SimpleStringProperty tel;

    public ClientFX (Client client){
        this.id = new SimpleLongProperty(client.getId());
        this.nom = new SimpleStringProperty(client.getNom());
        this.prenom =  new SimpleStringProperty(client.getPrenom());
        this.adresse =  new SimpleStringProperty(client.getAdresse());
        this.tel =  new SimpleStringProperty(client.getTel());
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

    public String getPrenom() {
        return prenom.get();
    }

    public SimpleStringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
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

    public String getTel() {
        return tel.get();
    }

    public SimpleStringProperty telProperty() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }
}
