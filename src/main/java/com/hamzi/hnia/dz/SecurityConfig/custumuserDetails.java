package com.hamzi.hnia.dz.SecurityConfig;

import com.hamzi.hnia.dz.Models.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class custumuserDetails implements UserDetails {
    private Users users;

    public custumuserDetails(Users users) {
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return users.getRoles().stream().map(roles ->  new SimpleGrantedAuthority(roles.getDesignationRole())).toList();
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUsername();
    }


}
