package com.hamzi.hnia.dz.Services.CommandeFrournisseur;

import com.hamzi.hnia.dz.Models.*;
import com.hamzi.hnia.dz.ModelsFX.CartItemsFX;

import java.util.List;

public interface commandeFService {
    CommandeFournisseur createCommandeFournisseur(Fournisseur fournisseur, List<CartItemsFX> cart);
    CommandeFournisseur changerStatut(Long commandeId, StatutCommande statut);
}
