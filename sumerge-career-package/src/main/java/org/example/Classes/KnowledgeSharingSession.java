package org.example.Classes;

import javax.persistence.*;

@Entity
@Table(
        name = "knowledge_sharing_session"
)
public class KnowledgeSharingSession {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String topic;
    private String date;
    private String targetAudience;
    private String feedbackLink;
    private String proof;

    @ManyToOne
    @JoinColumn(name = "employee_career_package_id")
    private EmployeeCareerPackage employeeCareerPackage;

    public KnowledgeSharingSession(){}

    public KnowledgeSharingSession(String topic, String date, String targetAudience, String feedbackLink, String proof, EmployeeCareerPackage employeeCareerPackage) {
        this.topic = topic;
        this.date = date;
        this.targetAudience = targetAudience;
        this.feedbackLink = feedbackLink;
        this.proof = proof;
        this.employeeCareerPackage = employeeCareerPackage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getFeedbackLink() {
        return feedbackLink;
    }

    public void setFeedbackLink(String feedbackLink) {
        this.feedbackLink = feedbackLink;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

    public EmployeeCareerPackage getEmployeeCareerPackage() {
        return employeeCareerPackage;
    }

    public void setEmployeeCareerPackage(EmployeeCareerPackage employeeCareerPackage) {
        this.employeeCareerPackage = employeeCareerPackage;
    }
}
