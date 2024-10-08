package org.example.Classes;

import javax.persistence.*;

@Entity
@Table(
        name = "additional_reference"
)
public class AdditionalReference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "employee_career_package_id", nullable = false)
    private EmployeeCareerPackage employeeCareerPackage;

    public AdditionalReference(String description, String title, EmployeeCareerPackage employeeCareerPackage) {
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

    public EmployeeCareerPackage getEmployeeCareerPackage() {
        return employeeCareerPackage;
    }

    public void setEmployeeCareerPackage(EmployeeCareerPackage employeeCareerPackage) {
        this.employeeCareerPackage = employeeCareerPackage;
    }
}
