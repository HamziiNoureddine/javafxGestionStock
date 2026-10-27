package com.hamzi.hnia.dz.ModelsFX;

import com.hamzi.hnia.dz.Annotation.FXColumn;
import com.hamzi.hnia.dz.Models.Roles;
import com.hamzi.hnia.dz.Models.Users;
import com.hamzi.hnia.dz.Utils.FXModel;
import jakarta.persistence.*;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class UsersFX {
    @FXColumn(title = "ID",order = 0)
    private final IntegerProperty codeUser;
    @FXColumn(title = "UserName",order = 1)
    private final StringProperty username;

    private final StringProperty password;
    @FXColumn(title = "Email",order = 2)
    private final StringProperty email;
    @FXColumn(title = "Roles",order = 3)
    private final StringProperty roles;

    public UsersFX(Users user){

        this.codeUser = new SimpleIntegerProperty(user.getCodeUser());

        this.username = new SimpleStringProperty(user.getUsername());

        this.password = new SimpleStringProperty(user.getPassword());

        this.email = new SimpleStringProperty(user.getEmail());

        this.roles =
                user.getRoles() != null
                        ? new SimpleStringProperty(
                        user.getRoles()
                                .stream()
                                .map(r -> r.getDesignationRole().name())
                                .collect(Collectors.joining(" & "))
                )
                        : new SimpleStringProperty("");
    }

    public IntegerProperty codeUserProperty(){
        return codeUser;
    }

    public int getCodeUser(){
        return codeUser.get();
    }

    public void setCodeUser(int value){
        codeUser.set(value);
    }

    public StringProperty usernameProperty(){
        return username;
    }

    public String getUsername(){
        return username.get();
    }

    public void setUsername(String value){
        username.set(value);
    }

    public StringProperty passwordProperty(){
        return password;
    }

    public String getPassword(){
        return password.get();
    }

    public void setPassword(String value){
        password.set(value);
    }

    public StringProperty emailProperty(){
        return email;
    }

    public String getEmail(){
        return email.get();
    }

    public void setEmail(String value){
        email.set(value);
    }

    public StringProperty rolesProperty(){
        return roles;
    }

    public String getRoles(){
        return roles.get();
    }

    public void setRoles(String value){
        roles.set(value);
    }
}