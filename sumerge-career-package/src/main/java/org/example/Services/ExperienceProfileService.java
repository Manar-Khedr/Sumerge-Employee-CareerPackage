package org.example.Services;

import org.example.Classes.EmployeeCareerPackage;
import org.example.Classes.ExperienceProfile;
import org.example.Exceptions.ExistsException;
import org.example.Mappers.ExperienceProfileDTO;
import org.example.Mappers.ExperienceProfileMapper;
import org.example.Repositories.EmployeeCareerPackageRepository;
import org.example.Repositories.ExperienceProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceProfileService {
    private final EmployeeCareerPackageRepository employeeCareerPackageRepository;
    private final ExperienceProfileRepository experiencwProfileRepository;
    private final ExperienceProfileMapper experienceProfileMapper;

    public ExperienceProfileService(EmployeeCareerPackageRepository employeeCareerPackageRepository, ExperienceProfileRepository experiencwProfileRepository, ExperienceProfileMapper experienceProfileMapper) {
        this.employeeCareerPackageRepository = employeeCareerPackageRepository;
        this.experiencwProfileRepository = experiencwProfileRepository;
        this.experienceProfileMapper = experienceProfileMapper;
    }

    public void createExperienceProfile(ExperienceProfileDTO experienceProfileDTO){
        if(experiencwProfileRepository.findById(experienceProfileDTO.getId()).isPresent()){
            throw new ExistsException("Experience Profile already exists");
        }
        Optional<EmployeeCareerPackage> employeeCareerPackage = employeeCareerPackageRepository.findByEmployeeId(experienceProfileDTO.getEmployeeCareerPackage().getEmployeeId());
        if(employeeCareerPackage.isEmpty()){
            throw new ExistsException("Employee Career Package does not exist");
        }
        ExperienceProfile experienceProfile = experienceProfileMapper.experienceProfileDTOToExperienceProfile(experienceProfileDTO);
        experienceProfile.setEmployeeCareerPackage(employeeCareerPackage.get());
        experiencwProfileRepository.save(experienceProfile);
    }

    public void deleteExperienceProfile(int id){
        Optional<ExperienceProfile> experienceProfile = experiencwProfileRepository.findById(id);
        if(experienceProfile.isEmpty()){
            throw new ExistsException("Experience Profile does not exist");
        }
        experiencwProfileRepository.delete(experienceProfile.get());
    }

    public void updateExperienceProfile(ExperienceProfileDTO experienceProfileDTO){
        Optional<ExperienceProfile> experienceProfile = experiencwProfileRepository.findById(experienceProfileDTO.getId());
        if(experienceProfile.isEmpty()){
            throw new ExistsException("Experience Profile does not exist");
        }
        Optional<EmployeeCareerPackage> employeeCareerPackage = employeeCareerPackageRepository.findByEmployeeId(experienceProfileDTO.getEmployeeCareerPackage().getEmployeeId());
        if(employeeCareerPackage.isEmpty()){
            throw new ExistsException("Employee Career Package does not exist");
        }

        ExperienceProfile updatedExperienceProfile = experienceProfile.get();
        updatedExperienceProfile.setEmployeeCareerPackage(employeeCareerPackage.get());
        experiencwProfileRepository.save(updatedExperienceProfile);
    }

    public ExperienceProfileDTO getExperienceProfile(int id){
        Optional<ExperienceProfile> experienceProfile = experiencwProfileRepository.findById(id);
        if(experienceProfile.isEmpty()){
            throw new ExistsException("Experience Profile does not exist");
        }
        return experienceProfileMapper.experienceProfileToExperienceProfileDTO(experienceProfile.get());
    }

    public List<ExperienceProfileDTO> getAllExperienceProfile(){
        List<ExperienceProfile> experienceProfiles = experiencwProfileRepository.findAll();
        return experienceProfileMapper.experienceProfileListToExperienceProfileDTO(experienceProfiles);
    }
}
