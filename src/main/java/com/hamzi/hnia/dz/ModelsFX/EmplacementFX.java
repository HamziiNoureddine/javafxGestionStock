package com.hamzi.hnia.dz.ModelsFX;

import com.hamzi.hnia.dz.Models.Emplacement;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmplacementFX {
    private SimpleLongProperty id;

    private SimpleStringProperty nom; // Ex: "Entrepôt A", "Rayon B2"
    private SimpleStringProperty adresse;
    private SimpleStringProperty rayonnage;
    private SimpleStringProperty etagere ;

    public EmplacementFX(Emplacement em) {

      this.id = new SimpleLongProperty(em.getId());
      this.nom = new SimpleStringProperty(em.getNom());
      this.adresse = new SimpleStringProperty(em.getAdresse());
      this.rayonnage = new SimpleStringProperty(em.getRayonnage());
      this.etagere  = new SimpleStringProperty(em.getEtagere());

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

    public String getAdresse() {
        return adresse.get();
    }

    public SimpleStringProperty adresseProperty() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }

    public String getRayonnage() {
        return rayonnage.get();
    }

    public SimpleStringProperty rayonnageProperty() {
        return rayonnage;
    }

    public void setRayonnage(String rayonnage) {
        this.rayonnage.set(rayonnage);
    }

    public String getEtagere() {
        return etagere.get();
    }

    public SimpleStringProperty etagereProperty() {
        return etagere;
    }

    public void setEtagere(String etagere) {
        this.etagere.set(etagere);
    }
}
