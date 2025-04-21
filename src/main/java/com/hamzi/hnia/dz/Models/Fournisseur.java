package com.hamzi.hnia.dz.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Table(name = "fournisseurs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fournisseur {
    @Id
    @GeneratedValue
    private Long id;

    private String nom;
    private String email;
    private String telephone;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandes; // Relation avec CommandeFournisseur

    // ...
}