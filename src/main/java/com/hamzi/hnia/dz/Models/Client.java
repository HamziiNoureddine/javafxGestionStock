package com.hamzi.hnia.dz.Models;



import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clients")

public class Client {
    @Id
    @GeneratedValue
    private Long id;

    private String nom;
    private String prenom;
    private String adresse;
    private String tel;

    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandes;

    public Client() {

    }

    public Client(Long id, String nom, String prenom, String adresse, String tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<CommandeClient> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<CommandeClient> commandes) {
        this.commandes = commandes;
    }

    // ...
}