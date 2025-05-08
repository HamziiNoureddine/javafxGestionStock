package com.hamzi.hnia.dz.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "stocks")

public class Stock {
    @EmbeddedId
    private StockProduitId id;
    private int quantite;
    @MapsId("produitId")
    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;
    @MapsId("emplacementId")
    @ManyToOne
    @JoinColumn(name = "emplacement_id")
    private Emplacement emplacement;

    public Stock() {
    }

    public Stock(int quantite, Produit produit, Emplacement emplacement) {

        this.quantite = quantite;
        this.produit = produit;
        this.emplacement = emplacement;
    }


    public StockProduitId getId() {
        return id;
    }

    public void setId(StockProduitId id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Emplacement getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Emplacement emplacement) {
        this.emplacement = emplacement;
    }

    // ...
}