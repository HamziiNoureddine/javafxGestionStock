package com.hamzi.hnia.dz.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "commandes_client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandeClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCommande; // Ex: "VENTE-2023-001"
    private LocalDate date;
    private StatutCommande statut; // Enum: EN_ATTENTE, LIVREE, ANNULEE

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LigneCommandeClient> lignes;

    // Getters/Setters + Constructeurs...
}