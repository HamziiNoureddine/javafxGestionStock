package com.hamzi.hnia.dz.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;


@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codeRole;

    @Enumerated(EnumType.STRING)
    private RolesType designationRole;

    public Integer getCodeRole() {
        return codeRole;
    }

    public void setCodeRole(Integer codeRole) {
        this.codeRole = codeRole;
    }


    public RolesType getDesignationRole() {
        return designationRole;
    }

    public void setDesignationRole(RolesType designationRole) {
        this.designationRole = designationRole;
    }
}
