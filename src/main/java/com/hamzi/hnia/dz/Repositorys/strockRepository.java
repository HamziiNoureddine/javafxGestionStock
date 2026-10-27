package com.hamzi.hnia.dz.Repositorys;

import com.hamzi.hnia.dz.Models.Stock;
import com.hamzi.hnia.dz.Models.StockProduitId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface strockRepository extends JpaRepository<Stock, StockProduitId> {
}
