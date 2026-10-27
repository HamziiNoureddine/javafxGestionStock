package com.hamzi.hnia.dz.ModelsFX;

import com.hamzi.hnia.dz.Models.Categorie;
import com.hamzi.hnia.dz.Models.Produit;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class CategorieFX {

    private SimpleLongProperty id;

    private SimpleStringProperty  nom;

    private SimpleStringProperty description;

    private SimpleStringProperty produits; // Relation inverse

    public CategorieFX(Categorie categorie) {
        this.id = new SimpleLongProperty(categorie.getId());
        this.nom = new SimpleStringProperty(categorie.getNom());
        this.description = new SimpleStringProperty(categorie.getDescription());

        this.produits = categorie.getProduits() != null ? new SimpleStringProperty(categorie.getProduits().stream().map(Produit::getNom).collect(Collectors.joining("-"))):new SimpleStringProperty("");
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

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getProduits() {
        return produits.get();
    }

    public SimpleStringProperty produitsProperty() {
        return produits;
    }

    public void setProduits(String produits) {
        this.produits.set(produits);
    }
}
