package com.hamzi.hnia.dz.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Table(name = "fournisseurs")

public class Fournisseur {
    @Id
    @GeneratedValue
    private Long id;

    private String nom;
    private String email;
    private String telephone;
    private String adresse;
    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandes; // Relation avec CommandeFournisseur

    public Fournisseur() {
    }

    public Fournisseur(Long id, String nom, String email, String telephone, String adresse) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<CommandeFournisseur> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<CommandeFournisseur> commandes) {
        this.commandes = commandes;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    // ...
}