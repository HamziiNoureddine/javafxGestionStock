package com.hamzi.hnia.dz.Models;

import jakarta.persistence.*;


@Entity
@Table(name = "lignes_commande_client")

public class LigneCommandeClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantite;
    private double prixUnitaire; // Prix au moment de la vente

    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "commande_id", nullable = false)
    private CommandeClient commande;

    public LigneCommandeClient() {
    }

    public LigneCommandeClient(Long id, int quantite, double prixUnitaire, Produit produit, CommandeClient commande) {
        this.id = id;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.produit = produit;
        this.commande = commande;
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

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public CommandeClient getCommande() {
        return commande;
    }

    public void setCommande(CommandeClient commande) {
        this.commande = commande;
    }

    public double getTotal() {
        return quantite * prixUnitaire; // ✅ Dynamique
    }

    // ...
}