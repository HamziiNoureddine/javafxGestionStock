package com.hamzi.hnia.dz.Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Panier implements Serializable {

    private Map<Long,LigneCommandeClient> items = new HashMap<Long, LigneCommandeClient>();

    public void addArticle(Produit p, int quantite)
    {
        if( items.get(p.getId()) != null )
        {
            items.get(p.getId()).setQuantite(quantite + items.get(p.getId()).getQuantite());
        }
        else
        {
            LigneCommandeClient ligneCommande = new LigneCommandeClient();
            ligneCommande.setProduit(p);
            ligneCommande.setQuantite(quantite);
            ligneCommande.setPrixUnitaire(p.getPrixAchatMoyen());
        }

    }


    public Collection<LigneCommandeClient> getCommandes()
    {
        return items.values();
    }

//    public BigDecimal getTotal()
//    {
//        double total = 0;
//        for ( LigneCommandeClient l : items.values())
//            total  l.getPrixUnitaire().multiply(BigDecimal.valueOf( l.getQuantite())) ;
//
//        return total;
//    }

    public int getSize()
    {
        return items.size();
    }

    public void deleteProduit(Long idProduit)
    {
        items.remove(idProduit);
    }



}
