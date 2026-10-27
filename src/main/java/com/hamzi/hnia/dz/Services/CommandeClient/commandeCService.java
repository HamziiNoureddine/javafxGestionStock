package com.hamzi.hnia.dz.Services.CommandeClient;

import com.hamzi.hnia.dz.Models.Client;
import com.hamzi.hnia.dz.Models.CommandeClient;
import com.hamzi.hnia.dz.Models.StatutCommande;
import com.hamzi.hnia.dz.ModelsFX.CartItemsFX;

import java.util.List;

public interface commandeCService {
    CommandeClient createCommande(Client client, List<CartItemsFX> cart);
    CommandeClient changerStatut(Long commandeId, StatutCommande statut);
}
