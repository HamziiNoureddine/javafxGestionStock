package com.hamzi.hnia.dz.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer codeUser;
    private String username;
    private String password;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST} )
    private List<Roles> roles;

    public Users() {

    }

    public Users(Integer codeUser, String username, String password, String email, List<Roles> roles) {
        this.codeUser = codeUser;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public Integer getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(Integer codeUser) {
        this.codeUser = codeUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
