package org.example.Services;

import org.example.Classes.CareerPackageTemplate;
import org.example.Classes.EmployeeCareerPackage;
import org.example.Exceptions.ExistsException;
import org.example.Mappers.EmployeeCareerPackageDTO;
import org.example.Mappers.EmployeeCareerPackageMapper;
import org.example.Repositories.CareerPackageTemplateRepository;
import org.example.Repositories.EmployeeCareerPackageRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeCareerPackageService {

    private EmployeeCareerPackageMapper employeeCareerPackageMapper;
    private EmployeeCareerPackageRepository employeeCareerPackageRepository;
    private CareerPackageTemplateRepository careerPackageTemplateRepository;

    public EmployeeCareerPackageService(EmployeeCareerPackageMapper employeeCareerPackageMapper, EmployeeCareerPackageRepository employeeCareerPackageRepository, CareerPackageTemplateRepository careerPackageTemplateRepository) {
        this.employeeCareerPackageMapper = employeeCareerPackageMapper;
        this.employeeCareerPackageRepository = employeeCareerPackageRepository;
        this.careerPackageTemplateRepository = careerPackageTemplateRepository;
    }

    public void createEmployeeCareerPackage(EmployeeCareerPackageDTO employeeCareerPackageDTO){
        if(employeeCareerPackageRepository.findByEmployeeId(employeeCareerPackageDTO.getEmployeeId()).isPresent()){
            throw new ExistsException("Employee Career Package already exists.");
        }
        Optional<CareerPackageTemplate> careerPackageTemplate = careerPackageTemplateRepository.findById(employeeCareerPackageDTO.getCareerPackageTemplate().getId());
        if(careerPackageTemplate.isEmpty()){
            throw new ExistsException("Career Package does not exist");
        }
        EmployeeCareerPackage employeeCareerPackage = employeeCareerPackageMapper.employeeCareerPackageDTOToEmployeeCareerPackage(employeeCareerPackageDTO);
        employeeCareerPackage.setCareerPackageTemplate(careerPackageTemplate.get());
        employeeCareerPackageRepository.save(employeeCareerPackage);
    }

    public void deleteEmployeeCareerPackage(int employeeId){
        Optional<EmployeeCareerPackage> employeeCareerPackage = employeeCareerPackageRepository.findByEmployeeId(employeeId);
        if(employeeCareerPackage.isEmpty()){
            throw new ExistsException("Employee Career Package does not exist");
        }
        employeeCareerPackageRepository.delete(employeeCareerPackage.get());
    }

    public void updateEmployeeCareerPackage(EmployeeCareerPackageDTO employeeCareerPackageDTO){
        Optional<EmployeeCareerPackage> employeeCareerPackage = employeeCareerPackageRepository.findByEmployeeId(employeeCareerPackageDTO.getEmployeeId());
        if(employeeCareerPackage.isEmpty()){
            throw new ExistsException("Employee Career Package does not exist.");
        }
        Optional<CareerPackageTemplate> careerPackageTemplate = careerPackageTemplateRepository.findById(employeeCareerPackageDTO.getCareerPackageTemplate().getId());
        if(careerPackageTemplate.isEmpty()){
            throw new ExistsException("Career Package does not exist");
        }
        EmployeeCareerPackage updatedEmployeeCareerPackage = employeeCareerPackage.get();
        updatedEmployeeCareerPackage.setCareerPackageTemplate(careerPackageTemplate.get());
        employeeCareerPackageRepository.save(updatedEmployeeCareerPackage);
    }

    public EmployeeCareerPackageDTO getEmployeeCareerPackage(int employeeId){
        Optional<EmployeeCareerPackage> employeeCareerPackage = employeeCareerPackageRepository.findByEmployeeId(employeeId);
        if(employeeCareerPackage.isEmpty()){
            throw new ExistsException("Employee Career Package does not exist.");
        }
        return employeeCareerPackageMapper.employeeCareerPackageToEmployeeCareerPackageDTO(employeeCareerPackage.get());
    }

    public List<EmployeeCareerPackageDTO> getAllEmployeeCareerPackages(){
        List<EmployeeCareerPackage> employeeCareerPackages = employeeCareerPackageRepository.findAll();
        return employeeCareerPackageMapper.employeeCareerPackageListToEmployeeCareerPackageDTOList(employeeCareerPackages);
    }

}
