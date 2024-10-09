package org.example.Classes;


import javax.persistence.*;

@Entity
@Table(
        name = "improvement_initiatives"
)
public class ImprovementInitiatives {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String benificiaries;
    private String result;
    private String proof;
    @ManyToOne
    @JoinColumn
    private EmployeeCareerPackage employeeCareerPackage;

    public ImprovementInitiatives(){}

    public ImprovementInitiatives(String description, String benificiaries, String result, String proof, EmployeeCareerPackage employeeCareerPackage) {
        this.description = description;
        this.benificiaries = benificiaries;
        this.result = result;
        this.proof = proof;
        this.employeeCareerPackage = employeeCareerPackage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBenificiaries() {
        return benificiaries;
    }

    public void setBenificiaries(String benificiaries) {
        this.benificiaries = benificiaries;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public EmployeeCareerPackage getEmployeeCareerPackage() {
        return employeeCareerPackage;
    }

    public void setEmployeeCareerPackage(EmployeeCareerPackage employeeCareerPackage) {
        this.employeeCareerPackage = employeeCareerPackage;
    }
}
