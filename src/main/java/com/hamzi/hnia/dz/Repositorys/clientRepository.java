package com.hamzi.hnia.dz.Repositorys;

import com.hamzi.hnia.dz.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientRepository extends JpaRepository<Client,Long> {
}
