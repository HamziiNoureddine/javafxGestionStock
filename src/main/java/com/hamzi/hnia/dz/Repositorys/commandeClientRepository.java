package com.hamzi.hnia.dz.Repositorys;

import com.hamzi.hnia.dz.Models.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commandeClientRepository extends JpaRepository<CommandeClient,Long> {
}
