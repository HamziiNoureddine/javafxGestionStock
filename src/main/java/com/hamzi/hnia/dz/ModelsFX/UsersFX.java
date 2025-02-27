package com.hamzi.hnia.dz.ModelsFX;

import com.hamzi.hnia.dz.Models.Roles;
import com.hamzi.hnia.dz.Models.Users;
import jakarta.persistence.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class UsersFX {

    private final SimpleIntegerProperty codeUser;
    private final SimpleStringProperty username;
    private final SimpleStringProperty password;
    private final SimpleStringProperty email;
    private final SimpleStringProperty roles;

    public UsersFX(Users user){
        this.codeUser = new SimpleIntegerProperty(user.getCodeUser());
        this.username =  new SimpleStringProperty(user.getUsername());
        this.password = new SimpleStringProperty(user.getPassword());
        this.roles = user.getRoles()!= null ? new SimpleStringProperty(user.getRoles().stream().map(roles -> roles.getDesignationRole().name()).collect(Collectors.joining(" & "))):new SimpleStringProperty("");
        this.email = new SimpleStringProperty(user.getEmail());
    }

    public int getCodeUser() {

        return codeUser.get();
    }

   public void setCodeUser(int codeUser) {
        this.codeUser.set(codeUser);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getRoles() {
        return roles.get();
    }



    public void setRoles(String roles) {
        this.roles.set(roles);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}
