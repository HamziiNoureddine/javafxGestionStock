package com.hamzi.hnia.dz.Models;

import jakarta.persistence.*;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "commandes_client")

public class CommandeClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCommande; // Ex: "VENTE-2023-001"
    private LocalDateTime date ;
    @Enumerated(EnumType.STRING)
    private StatutCommande statut; // Enum: EN_ATTENTE, LIVREE, ANNULEE
    private double total;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LigneCommandeClient> lignes;

    public CommandeClient() {
    }

    public CommandeClient(Long id, String numeroCommande, LocalDateTime date, StatutCommande statut, Client client) {
        this.id = id;
        this.numeroCommande = numeroCommande;
        this.date = LocalDateTime.now();
        this.statut = statut;
        this.client = client;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public StatutCommande getStatut() {
        return statut;
    }

    public void setStatut(StatutCommande statut) {
        this.statut = statut;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<LigneCommandeClient> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneCommandeClient> lignes) {
        this.lignes = lignes;
    }

    // Getters/Setters + Constructeurs...
}