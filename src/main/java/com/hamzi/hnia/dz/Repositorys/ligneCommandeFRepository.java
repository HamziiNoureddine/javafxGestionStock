package com.hamzi.hnia.dz.Repositorys;

import com.hamzi.hnia.dz.Models.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ligneCommandeFRepository extends JpaRepository<LigneCommandeFournisseur,Long> {

        @Query("SELECT COALESCE(SUM(l.quantite), 0) FROM LigneCommandeFournisseur l WHERE l.produit.id = :produitId")

        int getQuantiteTotaleByProduit(@Param("produitId") Long produitId);

        // Alternative encore plus performante
        @Query(value = """
        SELECT SUM(l.quantite) 
        FROM ligne_commande_fournisseur l 
        WHERE l.produit_id = :produitId
        """, nativeQuery = true)
        Integer sumQuantiteByProduitId(@Param("produitId") Long produitId);
    }


