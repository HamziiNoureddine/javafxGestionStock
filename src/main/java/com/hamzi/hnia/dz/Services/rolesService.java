package com.hamzi.hnia.dz.Services;

import com.hamzi.hnia.dz.Models.Roles;
import com.hamzi.hnia.dz.Models.RolesType;

import java.util.List;

public interface rolesService {

    public Roles getRolesByDesignation(RolesType rolesType);
    public List<Roles> listRoles();
}
