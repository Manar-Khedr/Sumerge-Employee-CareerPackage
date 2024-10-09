package org.example.Mappers;

import org.example.Classes.EmployeeCareerPackage;

public class AdditionalReferenceDTO {

    private int id;
    private String title;
    private String description;
    private EmployeeCareerPackageDTO employeeCareerPackage;

    public AdditionalReferenceDTO(String description, String title, EmployeeCareerPackageDTO employeeCareerPackage) {
        this.description = description;
        this.title = title;
        this.employeeCareerPackage = employeeCareerPackage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmployeeCareerPackageDTO getEmployeeCareerPackage() {
        return employeeCareerPackage;
    }

    public void setEmployeeCareerPackage(EmployeeCareerPackageDTO employeeCareerPackage) {
        this.employeeCareerPackage = employeeCareerPackage;
    }
}
