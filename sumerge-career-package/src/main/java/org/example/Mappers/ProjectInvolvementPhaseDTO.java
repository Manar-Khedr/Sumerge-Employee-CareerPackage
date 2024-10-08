package org.example.Mappers;

import java.util.Date;

public class ProjectInvolvementPhaseDTO {

    private int id;
    private Date phaseStart;
    private Date phaseCompletion;
    private String phaseDescription;
    private ExperienceProfileDTO experienceProfile;

    public ProjectInvolvementPhaseDTO(Date phaseStart, Date phaseCompletion, String phaseDescription, ExperienceProfileDTO experienceProfile) {
        this.phaseStart = phaseStart;
        this.phaseCompletion = phaseCompletion;
        this.phaseDescription = phaseDescription;
        this.experienceProfile = experienceProfile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPhaseStart() {
        return phaseStart;
    }

    public void setPhaseStart(Date phaseStart) {
        this.phaseStart = phaseStart;
    }

    public String getPhaseDescription() {
        return phaseDescription;
    }

    public void setPhaseDescription(String phaseDescription) {
        this.phaseDescription = phaseDescription;
    }

    public Date getPhaseCompletion() {
        return phaseCompletion;
    }

    public void setPhaseCompletion(Date phaseCompletion) {
        this.phaseCompletion = phaseCompletion;
    }

    public ExperienceProfileDTO getExperienceProfile() {
        return experienceProfile;
    }

    public void setExperienceProfile(ExperienceProfileDTO experienceProfile) {
        this.experienceProfile = experienceProfile;
    }
}
