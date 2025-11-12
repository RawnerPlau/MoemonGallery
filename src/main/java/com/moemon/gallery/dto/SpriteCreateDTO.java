package com.moemon.gallery.dto;

import com.moemon.gallery.model.CreditRole;
import com.moemon.gallery.model.FormType;

public class SpriteCreateDTO {
    private Integer id;
    private String formName;
    private FormType formType;
    private boolean isEXForm;
    private boolean isShiny;
    private CreditDTO credit;

    public SpriteCreateDTO(Integer id, String formName, FormType formType, boolean isEXForm, boolean isShiny, CreditDTO credit) {
        this.id = id;
        this.formName = formName;
        this.formType = formType;
        this.isEXForm = isEXForm;
        this.isShiny = isShiny;
        this.credit = credit;
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

    public CreditDTO getCredit() {
        return credit;
    }

    public void setCredit(CreditDTO credit) {
        this.credit = credit;
    }
}

