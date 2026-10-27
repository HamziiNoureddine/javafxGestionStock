package com.hamzi.hnia.dz.Repositorys;

import com.hamzi.hnia.dz.Models.Emplacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface emplacementRepository extends JpaRepository<Emplacement,Long> {
}
