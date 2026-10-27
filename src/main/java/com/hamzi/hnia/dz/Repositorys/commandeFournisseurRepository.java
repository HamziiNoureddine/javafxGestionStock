package com.hamzi.hnia.dz.Repositorys;

import com.hamzi.hnia.dz.Models.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commandeFournisseurRepository extends JpaRepository<CommandeFournisseur,Long> {
}
