package com.hamzi.hnia.dz.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "lignes_commande")

public class LigneCommandeFournisseur {
    @Id
    @GeneratedValue
    private Long id;

    private int quantite;
    private double prixUnitaire;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private CommandeFournisseur commande;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    public LigneCommandeFournisseur() {
    }

    public LigneCommandeFournisseur(Long id, int quantite, double prixUnitaire, CommandeFournisseur commande, Produit produit) {
        this.id = id;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.commande = commande;
        this.produit = produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public CommandeFournisseur getCommande() {
        return commande;
    }

    public void setCommande(CommandeFournisseur commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public double getTotal() {
        return quantite * prixUnitaire;
    }

    // ...
}