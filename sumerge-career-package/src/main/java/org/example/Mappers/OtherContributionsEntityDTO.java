package org.example.Mappers;


public class OtherContributionsEntityDTO {

    private int id;
    private OtherContributionsTypeDTO otherContributionsType;
    private CareerPackageTemplateDTO careerPackageTemplate;
    private String entry;

    public OtherContributionsEntityDTO(){}

    public OtherContributionsEntityDTO(OtherContributionsTypeDTO otherContributionsType, CareerPackageTemplateDTO careerPackageTemplate, String entry) {
        this.otherContributionsType = otherContributionsType;
        this.careerPackageTemplate = careerPackageTemplate;
        this.entry = entry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OtherContributionsTypeDTO getOtherContributionsType() {
        return otherContributionsType;
    }

    public void setOtherContributionsType(OtherContributionsTypeDTO otherContributionsType) {
        this.otherContributionsType = otherContributionsType;
    }

    public CareerPackageTemplateDTO getCareerPackageTemplate() {
        return careerPackageTemplate;
    }

    public void setCareerPackageTemplate(CareerPackageTemplateDTO careerPackageTemplate) {
        this.careerPackageTemplate = careerPackageTemplate;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
