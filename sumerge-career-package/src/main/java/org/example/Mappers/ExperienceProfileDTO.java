package org.example.Mappers;

import org.example.Classes.EmployeeCareerPackage;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class ExperienceProfileDTO {

    private int id;
    private String profileName;
    private boolean metAcceptance;
    private String clientName;
    private String ProjectNature;
    private String projectLocation;
    private String EmployerName;
    private Date projectStart;
    private Date projectEnd;
    private Date employeeInvolvementStart;
    private Date employeeInvolvementEnd;
    private int projectTeamSize;
    private String responsibilities;
    private String buisinessOpportunity;
    private String problemScopeAndComplexity;
    private String relationshipWithClient;
    private String solutionContribution;
    private String teamRelationship;
    private String majorDeliverables;
    private String suggestions;
    private String moduleDescriptions;
    private String projectDeliveryComment;
    private String projectSuccessComment;
    private String lessonsLearned;

    private EmployeeCareerPackageDTO employeeCareerPackage;

    public ExperienceProfileDTO(String profileName, boolean metAcceptance, String clientName, String projectNature, String projectLocation, String employerName, Date projectStart, Date projectEnd, Date employeeInvolvementStart, Date employeeInvolvementEnd, int projectTeamSize, String responsibilities, String buisinessOpportunity, String problemScopeAndComplexity, String relationshipWithClient, String solutionContribution, String teamRelationship, String majorDeliverables, String suggestions, String moduleDescriptions, String projectDeliveryComment, String projectSuccessComment, String lessonsLearned, EmployeeCareerPackageDTO employeeCareerPackage) {
        this.profileName = profileName;
        this.metAcceptance = metAcceptance;
        this.clientName = clientName;
        ProjectNature = projectNature;
        this.projectLocation = projectLocation;
        EmployerName = employerName;
        this.projectStart = projectStart;
        this.projectEnd = projectEnd;
        this.employeeInvolvementStart = employeeInvolvementStart;
        this.employeeInvolvementEnd = employeeInvolvementEnd;
        this.projectTeamSize = projectTeamSize;
        this.responsibilities = responsibilities;
        this.buisinessOpportunity = buisinessOpportunity;
        this.problemScopeAndComplexity = problemScopeAndComplexity;
        this.relationshipWithClient = relationshipWithClient;
        this.solutionContribution = solutionContribution;
        this.teamRelationship = teamRelationship;
        this.majorDeliverables = majorDeliverables;
        this.suggestions = suggestions;
        this.moduleDescriptions = moduleDescriptions;
        this.projectDeliveryComment = projectDeliveryComment;
        this.projectSuccessComment = projectSuccessComment;
        this.lessonsLearned = lessonsLearned;
        this.employeeCareerPackage = employeeCareerPackage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public boolean isMetAcceptance() {
        return metAcceptance;
    }

    public void setMetAcceptance(boolean metAcceptance) {
        this.metAcceptance = metAcceptance;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public String getEmployerName() {
        return EmployerName;
    }

    public void setEmployerName(String employerName) {
        EmployerName = employerName;
    }

    public String getProjectNature() {
        return ProjectNature;
    }

    public void setProjectNature(String projectNature) {
        ProjectNature = projectNature;
    }

    public Date getProjectStart() {
        return projectStart;
    }

    public void setProjectStart(Date projectStart) {
        this.projectStart = projectStart;
    }

    public Date getProjectEnd() {
        return projectEnd;
    }

    public void setProjectEnd(Date projectEnd) {
        this.projectEnd = projectEnd;
    }

    public Date getEmployeeInvolvementStart() {
        return employeeInvolvementStart;
    }

    public void setEmployeeInvolvementStart(Date employeeInvolvementStart) {
        this.employeeInvolvementStart = employeeInvolvementStart;
    }

    public Date getEmployeeInvolvementEnd() {
        return employeeInvolvementEnd;
    }

    public void setEmployeeInvolvementEnd(Date employeeInvolvementEnd) {
        this.employeeInvolvementEnd = employeeInvolvementEnd;
    }

    public int getProjectTeamSize() {
        return projectTeamSize;
    }

    public void setProjectTeamSize(int projectTeamSize) {
        this.projectTeamSize = projectTeamSize;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getBuisinessOpportunity() {
        return buisinessOpportunity;
    }

    public void setBuisinessOpportunity(String buisinessOpportunity) {
        this.buisinessOpportunity = buisinessOpportunity;
    }

    public String getProblemScopeAndComplexity() {
        return problemScopeAndComplexity;
    }

    public void setProblemScopeAndComplexity(String problemScopeAndComplexity) {
        this.problemScopeAndComplexity = problemScopeAndComplexity;
    }

    public String getRelationshipWithClient() {
        return relationshipWithClient;
    }

    public void setRelationshipWithClient(String relationshipWithClient) {
        this.relationshipWithClient = relationshipWithClient;
    }

    public String getSolutionContribution() {
        return solutionContribution;
    }

    public void setSolutionContribution(String solutionContribution) {
        this.solutionContribution = solutionContribution;
    }

    public String getTeamRelationship() {
        return teamRelationship;
    }

    public void setTeamRelationship(String teamRelationship) {
        this.teamRelationship = teamRelationship;
    }

    public String getMajorDeliverables() {
        return majorDeliverables;
    }

    public void setMajorDeliverables(String majorDeliverables) {
        this.majorDeliverables = majorDeliverables;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public String getModuleDescriptions() {
        return moduleDescriptions;
    }

    public void setModuleDescriptions(String moduleDescriptions) {
        this.moduleDescriptions = moduleDescriptions;
    }

    public String getProjectDeliveryComment() {
        return projectDeliveryComment;
    }

    public void setProjectDeliveryComment(String projectDeliveryComment) {
        this.projectDeliveryComment = projectDeliveryComment;
    }

    public String getProjectSuccessComment() {
        return projectSuccessComment;
    }

    public void setProjectSuccessComment(String projectSuccessComment) {
        this.projectSuccessComment = projectSuccessComment;
    }

    public String getLessonsLearned() {
        return lessonsLearned;
    }

    public void setLessonsLearned(String lessonsLearned) {
        this.lessonsLearned = lessonsLearned;
    }

    public EmployeeCareerPackageDTO getEmployeeCareerPackage() {
        return employeeCareerPackage;
    }

    public void setEmployeeCareerPackage(EmployeeCareerPackageDTO employeeCareerPackage) {
        this.employeeCareerPackage = employeeCareerPackage;
    }
}
