package org.example.Mappers;


public class ImprovementInitiativesDTO {

    private int id;
    private String description;
    private String benificiaries;
    private String result;
    private String proof;
    private EmployeeCareerPackageDTO employeeCareerPackage;

    public ImprovementInitiativesDTO(){}

    public ImprovementInitiativesDTO(String description, String result, String benificiaries, String proof, EmployeeCareerPackageDTO employeeCareerPackage) {
        this.description = description;
        this.result = result;
        this.benificiaries = benificiaries;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

    public EmployeeCareerPackageDTO getEmployeeCareerPackage() {
        return employeeCareerPackage;
    }

    public void setEmployeeCareerPackage(EmployeeCareerPackageDTO employeeCareerPackage) {
        this.employeeCareerPackage = employeeCareerPackage;
    }
}
