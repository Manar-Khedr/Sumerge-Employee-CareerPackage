package org.example.Classes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "employee_career_package"
)
public class EmployeeCareerPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int employeeId; // from USERDB

    @ManyToOne
    @JoinColumn(name = "template_Id", nullable = false)
    private CareerPackageTemplate careerPackageTemplate;

    @OneToMany(mappedBy = "employeeCareerPackage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExperienceProfile> experienceProfileList;

    @OneToMany(mappedBy = "employeeCareerPackage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AdditionalReference> additionalReferences;

    @OneToMany(mappedBy = "employeeCareerPackage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<KnowledgeSharingSession> knowledgeSharingSessions;

    @OneToMany(mappedBy = "employeeCareerPackage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImprovementInitiatives> improvementInitiatives;

    public EmployeeCareerPackage(){}

    public EmployeeCareerPackage(int id, int employeeId, CareerPackageTemplate careerPackageTemplate) {
        this.id = id;
        this.employeeId = employeeId;
        this.careerPackageTemplate = careerPackageTemplate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public CareerPackageTemplate getCareerPackageTemplate() {
        return careerPackageTemplate;
    }

    public void setCareerPackageTemplate(CareerPackageTemplate careerPackageTemplate) {
        this.careerPackageTemplate = careerPackageTemplate;
    }
}
