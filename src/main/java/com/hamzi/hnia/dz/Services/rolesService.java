package com.hamzi.hnia.dz.Services;

import com.hamzi.hnia.dz.Models.Roles;
import com.hamzi.hnia.dz.Models.RolesType;

public interface rolesService {

    public Roles getRolesByDesignation(RolesType rolesType);
}
