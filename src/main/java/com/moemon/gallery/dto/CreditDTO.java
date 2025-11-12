package com.moemon.gallery.dto;

import com.moemon.gallery.model.CreditRole;

public class CreditDTO {
    private String name;
    private CreditRole creditRole;

    public CreditDTO() {
    }

    public CreditDTO(String name, CreditRole creditRole) {
        this.name = name;
        this.creditRole = creditRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreditRole getCreditRole() {
        return creditRole;
    }

    public void setCreditRole(CreditRole creditRole) {
        this.creditRole = creditRole;
    }
}
