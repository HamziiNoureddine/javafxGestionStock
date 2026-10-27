package com.hamzi.hnia.dz.Services.CommandeFrournisseur;

import com.hamzi.hnia.dz.Models.CommandeFournisseur;
import com.hamzi.hnia.dz.Models.Fournisseur;
import com.hamzi.hnia.dz.Models.LigneCommandeFournisseur;
import com.hamzi.hnia.dz.Models.StatutCommande;
import com.hamzi.hnia.dz.ModelsFX.CartItemsFX;
import com.hamzi.hnia.dz.Repositorys.commandeFournisseurRepository;
import com.hamzi.hnia.dz.Repositorys.ligneCommandeFRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class commandeFServiceImpl implements commandeFService{
    private commandeFournisseurRepository commandeFRepository;
    private ligneCommandeFRepository ligneCommandeFRepos;
    @Override
    public CommandeFournisseur createCommandeFournisseur(Fournisseur fournisseur, List<CartItemsFX> cart) {
        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setFournisseur(fournisseur);
        double total=0;
        for (CartItemsFX cf:cart){
            LigneCommandeFournisseur lf = new LigneCommandeFournisseur();
            lf.setCommande(commandeFournisseur);
            lf.setProduit(cf.getProduit());
            lf.setQuantite(lf.getQuantite());
            lf.setPrixUnitaire(lf.getPrixUnitaire());
            lf=ligneCommandeFRepos.save(lf);
            commandeFournisseur.getLignes().add(lf);
            total+=cf.getTotal().doubleValue();

        }
        commandeFournisseur.setTotal(total);
        return commandeFRepository.save(commandeFournisseur);
    }

    @Override
    public CommandeFournisseur changerStatut(Long commandeId, StatutCommande statut) {
        return null;
    }
}
