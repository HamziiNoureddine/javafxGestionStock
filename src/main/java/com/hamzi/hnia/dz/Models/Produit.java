package com.hamzi.hnia.dz.Models;

import jakarta.persistence.*;




import java.util.List;

@Entity
@Table(name = "produits")

public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String reference; // Ex: "PROD-001"

    private String nom;
    private String description;
    private double prixUnitaire;

    private double prixAchatMoyen; // Mise à jour automatique
    private double margePourcentage; // Ex: 30.0 pour 30%

    // Champ calculé (non persisté)

    private int seuilAlerte; // Stock minimum avant alerte

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    private List<Stock> stocks; // Relation avec Stock

    public Produit() {
    }

    public Produit(Long id, String reference, String nom, String description, double prixUnitaire, int seuilAlerte, Categorie categorie) {
        this.id = id;
        this.reference = reference;
        this.nom = nom;
        this.description = description;
        this.prixUnitaire = prixUnitaire;
        this.seuilAlerte = seuilAlerte;
        this.categorie = categorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getSeuilAlerte() {
        return seuilAlerte;
    }

    public void setSeuilAlerte(int seuilAlerte) {
        this.seuilAlerte = seuilAlerte;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    @Transient
    public double getPrixVente() {
        return prixAchatMoyen * (1 + margePourcentage / 100);
    }


}