package com.hamzi.hnia.dz.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "emplacements")

public class Emplacement {
    @Id
    @GeneratedValue
    private Long id;

    private String nom; // Ex: "Entrepôt A", "Rayon B2"
    private String adresse;
    private String rayonnage;
    private String etagere ;
     public Emplacement() {
    }

    public Emplacement(Long id, String nom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRayonnage() {
        return rayonnage;
    }

    public void setRayonnage(String rayonnage) {
        this.rayonnage = rayonnage;
    }

    public String getEtagere() {
        return etagere;
    }

    public void setEtagere(String etagere) {
        this.etagere = etagere;
    }

// ...
}