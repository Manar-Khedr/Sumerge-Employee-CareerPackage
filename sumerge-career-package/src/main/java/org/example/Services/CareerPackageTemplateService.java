package org.example.Services;

import org.example.Classes.CareerPackageTemplate;
import org.example.Exceptions.ExistsException;
import org.example.Mappers.CareerPackageTemplateDTO;
import org.example.Mappers.CareerPackageTemplateMapper;
import org.example.Repositories.CareerPackageTemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CareerPackageTemplateService {

    private final CareerPackageTemplateRepository careerPackageTemplateRepository;
    private final CareerPackageTemplateMapper careerPackageTemplateMapper;

    public CareerPackageTemplateService(CareerPackageTemplateRepository careerPackageTemplateRepository, CareerPackageTemplateMapper careerPackageTemplateMapper) {
        this.careerPackageTemplateRepository = careerPackageTemplateRepository;
        this.careerPackageTemplateMapper = careerPackageTemplateMapper;
    }

    public void createCareerPackageTemplate(CareerPackageTemplateDTO careerPackageTemplateDTO){
        if(careerPackageTemplateRepository.findByPositionTitle(careerPackageTemplateDTO.getPositionTitle()).isPresent()){
            throw new ExistsException("Career Package Template already exists.");
        }
        careerPackageTemplateRepository.save(careerPackageTemplateMapper.careerPackageTemplateDTOToCareerPackageTemplate(careerPackageTemplateDTO));
    }

    public void deleteCareerPackage(int positionTitle){
        Optional<CareerPackageTemplate> careerPackageTemplate = careerPackageTemplateRepository.findByPositionTitle(positionTitle);
        if(careerPackageTemplate.isEmpty()){
            throw new ExistsException("Career Package does not exist");
        }
        careerPackageTemplateRepository.delete(careerPackageTemplate.get());
    }

    public void updateCareerPackageTemplate(CareerPackageTemplateDTO careerPackageTemplateDTO){
        Optional<CareerPackageTemplate> careerPackageTemplate = careerPackageTemplateRepository.findByPositionTitle(careerPackageTemplateDTO.getPositionTitle());
        if(careerPackageTemplate.isEmpty()){
            throw new ExistsException("Career Package does not exist");
        }

        CareerPackageTemplate updatedCareerPackageTemplate = careerPackageTemplate.get();
        updatedCareerPackageTemplate.setImprovementInitiativesRequired(careerPackageTemplateDTO.getImprovementInitiativesRequired());
        updatedCareerPackageTemplate.setPositionTitle(careerPackageTemplateDTO.getPositionTitle());
        updatedCareerPackageTemplate.setKnowledgeSharingSessionsRequired(careerPackageTemplateDTO.getKnowledgeSharingSessionsRequired());
        updatedCareerPackageTemplate.setRequiredExperienceProfiles(careerPackageTemplateDTO.getRequiredExperienceProfiles());
        updatedCareerPackageTemplate.setTotalLearningHoursRequired(careerPackageTemplateDTO.getTotalLearningHoursRequired());
        careerPackageTemplateRepository.save(updatedCareerPackageTemplate);
    }

    public CareerPackageTemplateDTO getCareerPackageTemplate(int positionTitle){
        Optional<CareerPackageTemplate> careerPackageTemplate = careerPackageTemplateRepository.findByPositionTitle(positionTitle);
        if(careerPackageTemplate.isEmpty()){
            throw new ExistsException("Career Package does not exist");
        }
        return careerPackageTemplateMapper.careerPackageTemplateToCareerPackageTemplateDTO(careerPackageTemplate.get());
    }

    public List<CareerPackageTemplateDTO> getCareerPackageTemplateDTOList(){
        List<CareerPackageTemplate> careerPackageTemplates = careerPackageTemplateRepository.findAll();
        return careerPackageTemplateMapper.careerPackageTemplateListToCareerPackageTemplateDTOList(careerPackageTemplates);
    }
}
