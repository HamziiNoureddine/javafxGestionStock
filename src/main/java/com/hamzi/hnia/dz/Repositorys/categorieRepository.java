package com.hamzi.hnia.dz.Repositorys;

import com.hamzi.hnia.dz.Models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categorieRepository extends JpaRepository<Categorie,Long> {
}
