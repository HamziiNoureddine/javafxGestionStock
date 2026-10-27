package com.hamzi.hnia.dz.Models;

import jakarta.persistence.*;


import java.math.BigDecimal;
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

    private int quantiteStock;
    private BigDecimal prixAchatMoyen; // Mise à jour automatique
    private BigDecimal margePourcentage; // Ex: 30.0 pour 30%
    private BigDecimal prixVente;
    private boolean autoriserStockNegatif;

    public BigDecimal getPrixAchatMoyen() {
        return prixAchatMoyen;
    }

    public void setPrixAchatMoyen(BigDecimal prixAchatMoyen) {
        this.prixAchatMoyen = prixAchatMoyen;
    }

    public BigDecimal getMargePourcentage() {
        return margePourcentage;
    }

    public void setMargePourcentage(BigDecimal margePourcentage) {
        this.margePourcentage = margePourcentage;
    }
// Champ calculé (non persisté)

    private int seuilAlerte; // Stock minimum avant alerte

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

//    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
//    private List<Stock> stocks; // Relation avec Stock

    public Produit() {
    }

    public Produit(Long id, String reference, String nom, String description, int seuilAlerte, Categorie categorie) {
        this.id = id;
        this.reference = reference;
        this.nom = nom;
        this.description = description;

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
    public int getQuantiteStock() {
        return quantiteStock;
    }

    public BigDecimal getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(BigDecimal prixVente) {
        this.prixVente = prixVente;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public boolean isAutoriserStockNegatif() {
        return autoriserStockNegatif;
    }
    public boolean isStockAlert(){
        return quantiteStock <= seuilAlerte;
    }


    public void setAutoriserStockNegatif(boolean autoriserStockNegatif) {
        this.autoriserStockNegatif = autoriserStockNegatif;
    }
}