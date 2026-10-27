package com.hamzi.hnia.dz.Repositorys;

import com.hamzi.hnia.dz.Models.Roles;
import com.hamzi.hnia.dz.Models.RolesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface rolesRepository extends JpaRepository<Roles,Integer> {

    public Roles findByDesignationRole(RolesType rolesType);

}
