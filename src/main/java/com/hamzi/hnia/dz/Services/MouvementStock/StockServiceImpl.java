package com.hamzi.hnia.dz.Services.MouvementStock;


import com.hamzi.hnia.dz.Models.MouvementStock;
import com.hamzi.hnia.dz.Models.Produit;
import com.hamzi.hnia.dz.Models.TypeMouvement;
import com.hamzi.hnia.dz.Repositorys.MouvementStockRepository;
import com.hamzi.hnia.dz.Repositorys.produitRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@Transactional
public class StockServiceImpl implements StockService{
       private MouvementStockRepository mouvementStockRepository;
       private produitRepository produitRepository;

    public StockServiceImpl(MouvementStockRepository mouvementStockRepository, produitRepository produitRepository) {
        this.mouvementStockRepository = mouvementStockRepository;
        this.produitRepository = produitRepository;
    }

    public void ajouterMouvement(Long produitId, TypeMouvement type, int quantite, BigDecimal prixAchat) {
            Produit produit = produitRepository.findById(produitId)
                    .orElseThrow(() -> new RuntimeException("Produit non trouvé"));

            MouvementStock mouvement = new MouvementStock();
            mouvement.setProduit(produit);
            mouvement.setTypeMouvement(type);
            mouvement.setQuantite(quantite);
            mouvementStockRepository.save(mouvement);
        switch (type){
            case SORTIE:
                int newStock = produit.getQuantiteStock() - quantite;
                boolean stockNegative = newStock < 0;
                boolean seuilAtteint = newStock <= produit.getSeuilAlerte();
                if (!produit.isAutoriserStockNegatif() && (stockNegative || seuilAtteint)) {

                    throw new RuntimeException("Stock insuffisant ou seuil d'alerte atteint");
                }

                produit.setQuantiteStock(
                        produit.getQuantiteStock() - quantite
                );
                break;

            case ENTREE:
                int ancienStock = produit.getQuantiteStock();

                BigDecimal ancienPrix =
                        produit.getPrixAchatMoyen() == null
                                ? BigDecimal.ZERO
                                : produit.getPrixAchatMoyen();

                BigDecimal valeurAncienStock =
                        ancienPrix.multiply(BigDecimal.valueOf(ancienStock));

                BigDecimal valeurNouvelAchat =
                        prixAchat.multiply(BigDecimal.valueOf(quantite));

                int nouveauStock = ancienStock + quantite;

                BigDecimal nouveauPrixMoyen =
                        valeurAncienStock.add(valeurNouvelAchat)
                                .divide(BigDecimal.valueOf(nouveauStock),2, RoundingMode.HALF_UP);

                produit.setQuantiteStock(nouveauStock);
                produit.setPrixAchatMoyen(nouveauPrixMoyen);

                produitRepository.save(produit);
                break;
            }

            produitRepository.save(produit);
        }



        public List<Produit> getTousProduits() {
            return produitRepository.findAll();
        }
    }

