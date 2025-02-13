package com.hamzi.hnia.dz.Repositorys;

import com.hamzi.hnia.dz.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRepository extends JpaRepository<Users,Integer> {
    public Users findByUsername(String username);
}
