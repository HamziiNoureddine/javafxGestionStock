package com.hamzi.hnia.dz.Services.CommandeClient;

import com.hamzi.hnia.dz.Models.*;
import com.hamzi.hnia.dz.ModelsFX.CartItemsFX;
import com.hamzi.hnia.dz.Repositorys.commandeClientRepository;
import com.hamzi.hnia.dz.Services.LigneCommandeClient.ligneCommandeCService;
import com.hamzi.hnia.dz.Services.MouvementStock.StockService;
import com.hamzi.hnia.dz.Services.Produit.produitService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public class commandeCServiceImpl implements commandeCService{
    private commandeClientRepository commandeCliRepository;
    private ligneCommandeCService ligneCCService;
    private produitService prodservice;
    private StockService stockService;

    public commandeCServiceImpl(commandeClientRepository commandeCliRepository, ligneCommandeCService ligneCCService, produitService prodservice, StockService stockService) {
        this.commandeCliRepository = commandeCliRepository;
        this.ligneCCService = ligneCCService;
        this.prodservice = prodservice;
        this.stockService = stockService;
    }

    @Override
    public CommandeClient createCommande(Client client, List<CartItemsFX> cart) {
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setClient(client);
        commandeClient.setStatut(StatutCommande.EN_ATTENTE);

        double total=0;
        for (CartItemsFX cartItem: cart) {

            LigneCommandeClient lcc = new LigneCommandeClient();
            lcc.setCommande(commandeClient);
            lcc.setProduit(cartItem.getProduit());
            lcc.setQuantite(cartItem.getQuantite());
            lcc.setPrixUnitaire(cartItem.getPrix());
            ligneCCService.ajoutLigneCommade(lcc);
            commandeClient.getLignes().add(lcc);

            total+= cartItem.getTotal().doubleValue();

        }
        commandeClient.setTotal(total);
        return  commandeCliRepository.save(commandeClient);

    }

    @Override
    public CommandeClient changerStatut(Long commandeId, StatutCommande statut) {
        CommandeClient commandeClient = commandeCliRepository.findById(commandeId).orElseThrow();
        commandeClient.setStatut(statut);
        if (statut==StatutCommande.LIVREE){
            for (LigneCommandeClient lcc:commandeClient.getLignes()){
                stockService.ajouterMouvement(lcc.getProduit().getId(),TypeMouvement.SORTIE,lcc.getQuantite(),null);
            }
        }

        return commandeClient;
    }
}
