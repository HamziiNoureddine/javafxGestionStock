package com.hamzi.hnia.dz.Services;

import com.hamzi.hnia.dz.Models.Roles;
import com.hamzi.hnia.dz.Models.RolesType;
import com.hamzi.hnia.dz.Repositorys.rolesRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class rolesServiceImpl implements rolesService{

    private rolesRepository repositoryroles;

    public rolesServiceImpl(rolesRepository repositoryRoles) {
        this.repositoryroles = repositoryRoles;
    }

    @Override
    public Roles getRolesByDesignation(RolesType rolesType) {
        return repositoryroles.findByDesignationRole(rolesType);
    }
}
