package com.hamzi.hnia.dz.ModelsFX;

import com.hamzi.hnia.dz.Models.Categorie;
import com.hamzi.hnia.dz.Models.Stock;
import jakarta.persistence.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class ProduitFX {

    private SimpleLongProperty id;


    private SimpleStringProperty reference; // Ex: "PROD-001"

    private SimpleStringProperty nom;
    private SimpleStringProperty description;

   // private double prixUnitaire;
    private SimpleIntegerProperty seuilAlerte; // Stock minimum avant alerte

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    private List<Stock> stocks; // Relation avec Stock

}
