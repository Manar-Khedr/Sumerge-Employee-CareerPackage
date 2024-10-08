package org.example.Classes;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
        name = "project_involvement_phase"
)
public class ProjectInvolvementPhase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date phaseStart;
    private Date phaseCompletion;
    private String phaseDescription;

    @ManyToOne
    @JoinColumn(name = "experience_profile_id")
    private ExperienceProfile experienceProfile;

    public ProjectInvolvementPhase(Date phaseStart, Date phaseCompletion, String phaseDescription, ExperienceProfile experienceProfile) {
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

    public ExperienceProfile getExperienceProfile() {
        return experienceProfile;
    }

    public void setExperienceProfile(ExperienceProfile experienceProfile) {
        this.experienceProfile = experienceProfile;
    }
}
