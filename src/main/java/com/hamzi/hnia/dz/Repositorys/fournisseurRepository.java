package com.hamzi.hnia.dz.Repositorys;

import com.hamzi.hnia.dz.Models.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface fournisseurRepository extends JpaRepository<Fournisseur,Long> {
}
