package org.example.Mappers;

public class EmployeeCareerPackageDTO {

    private int id;
    private CareerPackageTemplateDTO careerPackageTemplate;
    private int employeeId;

    public EmployeeCareerPackageDTO(){}

    public EmployeeCareerPackageDTO(CareerPackageTemplateDTO careerPackageTemplate, int employeeId) {
        this.careerPackageTemplate = careerPackageTemplate;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CareerPackageTemplateDTO getCareerPackageTemplate() {
        return careerPackageTemplate;
    }

    public void setCareerPackageTemplate(CareerPackageTemplateDTO careerPackageTemplate) {
        this.careerPackageTemplate = careerPackageTemplate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
