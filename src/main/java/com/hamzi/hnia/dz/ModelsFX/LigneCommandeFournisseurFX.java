package com.hamzi.hnia.dz.ModelsFX;

import com.hamzi.hnia.dz.Models.LigneCommandeClient;
import com.hamzi.hnia.dz.Models.LigneCommandeFournisseur;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class LigneCommandeFournisseurFX {
    private SimpleLongProperty id;

    private SimpleIntegerProperty quantite;

    private SimpleDoubleProperty prixUnitaire;
    // Prix au moment de la vente
    private SimpleStringProperty produit;

    private SimpleStringProperty commande;

    private SimpleDoubleProperty total;


    public LigneCommandeFournisseurFX(LigneCommandeFournisseur lcf) {
        this.id = new SimpleLongProperty(lcf.getId());
        this.quantite = new SimpleIntegerProperty(lcf.getQuantite());
        this.prixUnitaire = new SimpleDoubleProperty(lcf.getPrixUnitaire());
        this.produit = new SimpleStringProperty(lcf.getProduit().getNom());
        this.commande = new SimpleStringProperty(lcf.getCommande().getNumeroCommande());
        this.total = new SimpleDoubleProperty(lcf.getTotal());
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

    public int getQuantite() {
        return quantite.get();
    }

    public SimpleIntegerProperty quantiteProperty() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite.set(quantite);
    }

    public double getPrixUnitaire() {
        return prixUnitaire.get();
    }

    public SimpleDoubleProperty prixUnitaireProperty() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire.set(prixUnitaire);
    }

    public String getProduit() {
        return produit.get();
    }

    public SimpleStringProperty produitProperty() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit.set(produit);
    }

    public String getCommande() {
        return commande.get();
    }

    public SimpleStringProperty commandeProperty() {
        return commande;
    }

    public void setCommande(String commande) {
        this.commande.set(commande);
    }

    public double getTotal() {
        return total.get();
    }

    public SimpleDoubleProperty totalProperty() {
        return total;
    }

    public void setTotal(double total) {
        this.total.set(total);
    }
}
