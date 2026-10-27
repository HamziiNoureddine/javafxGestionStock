package com.hamzi.hnia.dz.Repositorys;

import com.hamzi.hnia.dz.Models.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ligneCommandeCRepository extends JpaRepository<LigneCommandeClient,Long> {
}
