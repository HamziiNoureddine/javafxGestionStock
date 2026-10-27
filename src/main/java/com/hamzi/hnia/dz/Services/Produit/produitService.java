package com.hamzi.hnia.dz.Services.Produit;

import com.hamzi.hnia.dz.Models.Produit;

import java.math.BigDecimal;

public interface produitService {
    public Produit ajoutProduit(Produit produit);
    public BigDecimal calculerPrixVente(BigDecimal prixAchat, double marge);
}
