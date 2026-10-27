package com.hamzi.hnia.dz.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hamzi.hnia.dz.Utils.FXModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@ToString
public class Users extends FXModel<Users> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer codeUser;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER )
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

    @Override
    public Users toEntity() {
        Users user = new Users();
        user.setCodeUser(getCodeUser());
        user.setUsername(getUsername());
        user.setPassword(getPassword());
        user.setEmail(getEmail());
        user.setRoles(getRoles());

        return user;
    }

    @Override
    public void fromEntity(Users Entity) {

    }
}
