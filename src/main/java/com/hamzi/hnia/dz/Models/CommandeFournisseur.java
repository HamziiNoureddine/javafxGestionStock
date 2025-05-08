package com.hamzi.hnia.dz.Models;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "commandes_fournisseur")

public class CommandeFournisseur {
    @Id
    @GeneratedValue
    private Long id;

    private String numeroCommande; // Ex: "CMD-2023-001"
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<LigneCommandeFournisseur> lignes;

    public CommandeFournisseur() {
    }

    public CommandeFournisseur(Long id, String numeroCommande, LocalDate date, Fournisseur fournisseur) {
        this.id = id;
        this.numeroCommande = numeroCommande;
        this.date = date;
        this.fournisseur = fournisseur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(String numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<LigneCommandeFournisseur> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneCommandeFournisseur> lignes) {
        this.lignes = lignes;
    }

    // ...
}