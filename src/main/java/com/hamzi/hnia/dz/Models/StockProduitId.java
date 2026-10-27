package com.hamzi.hnia.dz.Models;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class StockProduitId implements Serializable {
    private Long produitId;
    private Long emplacementId;

    public StockProduitId() {
    }

    public StockProduitId(Long produitId, Long emplacementId) {
        this.produitId = produitId;
        this.emplacementId = emplacementId;
    }

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }

    public Long getEmplacementId() {
        return emplacementId;
    }

    public void setEmplacementId(Long emplacementId) {
        this.emplacementId = emplacementId;
    }
}