package com.hamzi.hnia.dz.ModelsFX;

import com.hamzi.hnia.dz.Models.CommandeClient;
import com.hamzi.hnia.dz.Models.LigneCommandeClient;
import com.hamzi.hnia.dz.Models.Produit;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class LigneCommandeClientFX {

    private SimpleLongProperty id;

    private SimpleIntegerProperty quantite;

    private SimpleDoubleProperty prixUnitaire;
    // Prix au moment de la vente
    private SimpleStringProperty produit;

    private SimpleStringProperty commande;

    private SimpleDoubleProperty total;


    public LigneCommandeClientFX(LigneCommandeClient lcc) {
        this.id = new SimpleLongProperty(lcc.getId());
        this.quantite = new SimpleIntegerProperty(lcc.getQuantite());
        this.prixUnitaire = new SimpleDoubleProperty(lcc.getPrixUnitaire().doubleValue());
        this.produit = new SimpleStringProperty(lcc.getProduit().getNom());
        this.commande = new SimpleStringProperty(lcc.getCommande().getNumeroCommande());
        this.total = new SimpleDoubleProperty(lcc.getTotal().doubleValue());
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
