package com.hamzi.hnia.dz.Repositorys;

import com.hamzi.hnia.dz.Models.MouvementStock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MouvementStockRepository extends JpaRepository<MouvementStock, Long> {
    @Query("SELECT SUM(CASE WHEN m.typeMouvement = 'ENTREE' THEN m.quantite " +
            "WHEN m.typeMouvement = 'SORTIE' THEN -m.quantite " +
            "WHEN m.typeMouvement = 'AJUSTEMENT' THEN m.quantite END) " +
            "FROM MouvementStock m WHERE m.produit.id = :produitId")
    Integer getStockActuel(Long produitId);
}