package com.hamzi.hnia.dz.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codeRole;
    private String designationRole;

    public Integer getCodeRole() {
        return codeRole;
    }

    public void setCodeRole(Integer codeRole) {
        this.codeRole = codeRole;
    }

    public String getDesignationRole() {
        return designationRole;
    }

    public void setDesignationRole(String designationRole) {
        this.designationRole = designationRole;
    }
}
