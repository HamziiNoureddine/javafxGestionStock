package com.hamzi.hnia.dz.Services.LigneCommandeClient;

import com.hamzi.hnia.dz.Models.LigneCommandeClient;
import com.hamzi.hnia.dz.Repositorys.ligneCommandeCRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ligneCommandeCServiceImpl implements ligneCommandeCService{
    private ligneCommandeCRepository ligneCCRepository;

    public ligneCommandeCServiceImpl(ligneCommandeCRepository ligneCCRepository) {
        this.ligneCCRepository = ligneCCRepository;
    }


    @Override
    public LigneCommandeClient ajoutLigneCommade(LigneCommandeClient lcc) {
        return ligneCCRepository.save(lcc);
    }
}
