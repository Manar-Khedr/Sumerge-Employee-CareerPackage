package org.example.Classes;

import javax.persistence.*;

@Entity
@Table(
        name = "career_package_template"
)
public class CareerPackageTemplate {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private int positionTitle; // FROM --> USERDB
    private int requiredExperienceProfiles;
    private int totalLearningHoursRequired;
    private int knowledgeSharingSessionsRequired;
    private int improvementInitiativesRequired;

    public CareerPackageTemplate(){}

    public CareerPackageTemplate(int positionTitle, int requiredExperienceProfiles, int totalLearningHoursRequired, int knowledgeSharingSessionsRequired, int improvementInitiativesRequired) {
        this.positionTitle = positionTitle;
        this.requiredExperienceProfiles = requiredExperienceProfiles;
        this.totalLearningHoursRequired = totalLearningHoursRequired;
        this.knowledgeSharingSessionsRequired = knowledgeSharingSessionsRequired;
        this.improvementInitiativesRequired = improvementInitiativesRequired;
    }

    public int getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(int positionTitle) {
        this.positionTitle = positionTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequiredExperienceProfiles() {
        return requiredExperienceProfiles;
    }

    public void setRequiredExperienceProfiles(int requiredExperienceProfiles) {
        this.requiredExperienceProfiles = requiredExperienceProfiles;
    }

    public int getTotalLearningHoursRequired() {
        return totalLearningHoursRequired;
    }

    public void setTotalLearningHoursRequired(int totalLearningHoursRequired) {
        this.totalLearningHoursRequired = totalLearningHoursRequired;
    }

    public int getKnowledgeSharingSessionsRequired() {
        return knowledgeSharingSessionsRequired;
    }

    public void setKnowledgeSharingSessionsRequired(int knowledgeSharingSessionsRequired) {
        this.knowledgeSharingSessionsRequired = knowledgeSharingSessionsRequired;
    }

    public int getImprovementInitiativesRequired() {
        return improvementInitiativesRequired;
    }

    public void setImprovementInitiativesRequired(int improvementInitiativesRequired) {
        this.improvementInitiativesRequired = improvementInitiativesRequired;
    }
}
