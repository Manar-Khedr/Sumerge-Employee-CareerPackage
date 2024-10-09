package org.example.Mappers;


import org.example.Classes.CareerPackageTemplate;
import org.example.Classes.OtherContributionsType;

import java.util.List;

public class OtherContributionsRequirementDTO {
    private int id;
    // career package id

    private CareerPackageTemplateDTO careerPackageTemplate; // problem here
    private OtherContributionsTypeDTO otherContributionsType;
    private int amountRequired;

    public OtherContributionsRequirementDTO(){}

    public OtherContributionsRequirementDTO(CareerPackageTemplateDTO careerPackageTemplate, OtherContributionsTypeDTO otherContributionsType, int amountRequired) {
        this.careerPackageTemplate = careerPackageTemplate;
        this.otherContributionsType = otherContributionsType;
        this.amountRequired = amountRequired;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CareerPackageTemplateDTO getCareerPackageTemplate() {
        return careerPackageTemplate;
    }

    public void setCareerPackageTemplate(CareerPackageTemplateDTO careerPackageTemplate) {
        this.careerPackageTemplate = careerPackageTemplate;
    }

    public OtherContributionsTypeDTO getOtherContributionsType() {
        return otherContributionsType;
    }

    public void setOtherContributionsType(OtherContributionsTypeDTO otherContributionsType) {
        this.otherContributionsType = otherContributionsType;
    }

    public int getAmountRequired() {
        return amountRequired;
    }

    public void setAmountRequired(int amountRequired) {
        this.amountRequired = amountRequired;
    }
}
