package com.hamzi.hnia.dz.Models;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "categories")

public class Categorie {
    @Id
    @GeneratedValue
    private Long id;

    private String nom;
    private String description;

    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits; // Relation inverse

    public Categorie() {

    }

    public Categorie(Long id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }


// ...
}