package com.hamzi.hnia.dz.Repositorys;

import com.hamzi.hnia.dz.Models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface produitRepository extends JpaRepository<Produit,Long> {
}
