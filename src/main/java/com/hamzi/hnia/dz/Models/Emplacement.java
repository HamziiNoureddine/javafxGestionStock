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
@Table(name = "emplacements")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emplacement {
    @Id
    @GeneratedValue
    private Long id;

    private String nom; // Ex: "Entrepôt A", "Rayon B2"
    private String adresse;

    @OneToMany(mappedBy = "emplacement")
    private List<Stock> stocks; // Relation avec Stock

    // ...
}