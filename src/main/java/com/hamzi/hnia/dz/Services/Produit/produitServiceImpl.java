package com.hamzi.hnia.dz.Services.Produit;

import com.hamzi.hnia.dz.Models.Produit;
import com.hamzi.hnia.dz.Repositorys.produitRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
@Transactional
public class produitServiceImpl implements produitService {

    private produitRepository prodRepository;
    @Override
    public Produit ajoutProduit(Produit produit) {
        return prodRepository.save(produit);
    }

    @Override
    public BigDecimal calculerPrixVente(BigDecimal prixAchat, double marge) {
        BigDecimal margeValue =
                prixAchat.multiply(BigDecimal.valueOf(marge / 100));

        return prixAchat.add(margeValue);
    }
}
