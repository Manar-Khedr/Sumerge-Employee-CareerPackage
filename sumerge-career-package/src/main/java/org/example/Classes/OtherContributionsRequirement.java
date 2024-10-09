package org.example.Classes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "other_contributions_requirement"
)
public class OtherContributionsRequirement {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    // career package id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "career_package_template_id", referencedColumnName = "id")
    private CareerPackageTemplate careerPackageTemplate; // problem here
    @ManyToOne
    @JoinColumn(name = "other_contributions_types_id")
    private OtherContributionsType otherContributionsType;
    private int amountRequired;

    public OtherContributionsRequirement(){}

    public OtherContributionsRequirement(CareerPackageTemplate careerPackageTemplate, OtherContributionsType otherContributionsType, int amountRequired) {
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

    public CareerPackageTemplate getCareerPackageTemplate() {
        return careerPackageTemplate;
    }

    public void setCareerPackageTemplate(CareerPackageTemplate careerPackageTemplate) {
        this.careerPackageTemplate = careerPackageTemplate;
    }

    public OtherContributionsType getOtherContributionsType() {
        return otherContributionsType;
    }

    public void setOtherContributionsType(OtherContributionsType otherContributionsType) {
        this.otherContributionsType = otherContributionsType;
    }

    public int getAmountRequired() {
        return amountRequired;
    }

    public void setAmountRequired(int amountRequired) {
        this.amountRequired = amountRequired;
    }
}
