package org.example.Classes;

import javax.persistence.*;

@Entity
@Table(
        name = "other_contributions_entity"
)
public class OtherContributionsEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "other_contributions_types_id")
    private OtherContributionsType otherContributionsType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "career_package_template_id", referencedColumnName = "id")
    private CareerPackageTemplate careerPackageTemplate;
    private String entry;

    public OtherContributionsEntity(){}

    public OtherContributionsEntity(OtherContributionsType otherContributionsType, String entry, CareerPackageTemplate careerPackageTemplate) {
        this.otherContributionsType = otherContributionsType;
        this.entry = entry;
        this.careerPackageTemplate = careerPackageTemplate;
    }

    public CareerPackageTemplate getCareerPackageTemplate() {
        return careerPackageTemplate;
    }

    public void setCareerPackageTemplate(CareerPackageTemplate careerPackageTemplate) {
        this.careerPackageTemplate = careerPackageTemplate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OtherContributionsType getOtherContributionsType() {
        return otherContributionsType;
    }

    public void setOtherContributionsType(OtherContributionsType otherContributionsType) {
        this.otherContributionsType = otherContributionsType;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
