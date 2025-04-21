package com.hamzi.hnia.dz.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "lignes_commande")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommandeFournisseur {
    @Id
    @GeneratedValue
    private Long id;

    private int quantite;
    private double prixUnitaire;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private CommandeFournisseur commande;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    // ...
}