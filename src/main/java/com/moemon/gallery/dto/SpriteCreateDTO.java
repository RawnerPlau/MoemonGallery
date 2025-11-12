package com.moemon.gallery.dto;

import com.moemon.gallery.model.FormType;

import java.util.Set;

public class SpriteCreateDTO {
    private Integer id;
    private String formName;
    private FormType formType;
    private boolean isEXForm;
    private boolean isShiny;
    private Set<CreditDTO> credits;

    public SpriteCreateDTO(Integer id, String formName, FormType formType, boolean isEXForm, boolean isShiny, Set<CreditDTO> credit) {
        this.id = id;
        this.formName = formName;
        this.formType = formType;
        this.isEXForm = isEXForm;
        this.isShiny = isShiny;
        this.credits = credit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public FormType getFormType() {
        return formType;
    }

    public void setFormType(FormType formType) {
        this.formType = formType;
    }

    public boolean isEXForm() {
        return isEXForm;
    }

    public void setEXForm(boolean EXForm) {
        isEXForm = EXForm;
    }

    public boolean isShiny() {
        return isShiny;
    }

    public void setShiny(boolean shiny) {
        isShiny = shiny;
    }

    public Set<CreditDTO> getCredits() {
        return credits;
    }

    public void setCredits(Set<CreditDTO> credits) {
        this.credits = credits;
    }
}

