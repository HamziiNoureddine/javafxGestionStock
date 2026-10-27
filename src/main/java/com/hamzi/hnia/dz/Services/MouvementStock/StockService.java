package com.hamzi.hnia.dz.Services.MouvementStock;

import com.hamzi.hnia.dz.Models.TypeMouvement;

import java.math.BigDecimal;

public interface StockService {
    public void ajouterMouvement(Long produitId, TypeMouvement type, int quantite, BigDecimal prixAchat);
}
