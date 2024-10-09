package org.example.Services;


import org.example.Classes.CareerPackageTemplate;
import org.example.Classes.OtherContributionsRequirement;
import org.example.Classes.OtherContributionsType;
import org.example.Exceptions.ExistsException;
import org.example.Mappers.OtherContributionsRequirementDTO;
import org.example.Mappers.OtherContributionsRequirementMapper;
import org.example.Repositories.CareerPackageTemplateRepository;
import org.example.Repositories.OtherContributionsRequirementRepository;
import org.example.Repositories.OtherContrubutionsTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OtherContributionsRequirementService {

    private OtherContributionsRequirementMapper otherContributionsRequirementMapper;
    private OtherContributionsRequirementRepository otherContributionsRequirementRepository;
    private CareerPackageTemplateRepository careerPackageTemplateRepository;
    private OtherContrubutionsTypeRepository otherContrubutionsTypeRepository;

    public OtherContributionsRequirementService(OtherContributionsRequirementMapper otherContributionsRequirementMapper, OtherContributionsRequirementRepository otherContributionsRequirementRepository, CareerPackageTemplateRepository careerPackageTemplateRepository, OtherContrubutionsTypeRepository otherContrubutionsTypeRepository) {
        this.otherContributionsRequirementMapper = otherContributionsRequirementMapper;
        this.otherContributionsRequirementRepository = otherContributionsRequirementRepository;
        this.careerPackageTemplateRepository = careerPackageTemplateRepository;
        this.otherContrubutionsTypeRepository = otherContrubutionsTypeRepository;
    }

    public void createOtherContributionsRequirement(OtherContributionsRequirementDTO otherContributionsRequirementDTO){
        if(otherContributionsRequirementRepository.findById(otherContributionsRequirementDTO.getId()).isPresent()){
            throw new ExistsException("Other Contributions Requirement already exists");
        }
        Optional<CareerPackageTemplate> careerPackageTemplate = careerPackageTemplateRepository.findByPositionTitle(otherContributionsRequirementDTO.getCareerPackageTemplate().getPositionTitle());
        if(careerPackageTemplate.isEmpty()){
            throw new ExistsException("Career Package Template does not exist");
        }
        Optional<OtherContributionsType> otherContributionsType = otherContrubutionsTypeRepository.findByDescription(otherContributionsRequirementDTO.getOtherContributionsType().getDescription());
        if(otherContributionsType.isEmpty()){
            throw new ExistsException("Other Contributions Type does not exist");
        }

        OtherContributionsRequirement otherContributionsRequirement = otherContributionsRequirementMapper.otherContributionsRequirementDTOToOtherContributionsRequirement(otherContributionsRequirementDTO);
        otherContributionsRequirement.setOtherContributionsType(otherContributionsType.get());
        otherContributionsRequirement.setCareerPackageTemplate(careerPackageTemplate.get());
    }

    public void deleteOtherContributionsRequirement(int id){
        Optional<OtherContributionsRequirement> otherContributionsRequirement = otherContributionsRequirementRepository.findById(id);
        if(otherContributionsRequirement.isEmpty()){
            throw new ExistsException("Other Contributions Requirement does not exist");
        }
        otherContributionsRequirementRepository.delete(otherContributionsRequirement.get());
    }

    public void updateOtherContributionsRequirement(OtherContributionsRequirementDTO otherContributionsRequirementDTO){
        Optional<OtherContributionsRequirement> otherContributionsRequirement = otherContributionsRequirementRepository.findById(otherContributionsRequirementDTO.getId());
        if(otherContributionsRequirement.isEmpty()){
            throw new ExistsException("Other Contributions Requirement does not exist");
        }
        Optional<CareerPackageTemplate> careerPackageTemplate = careerPackageTemplateRepository.findByPositionTitle(otherContributionsRequirementDTO.getCareerPackageTemplate().getPositionTitle());
        if(careerPackageTemplate.isEmpty()){
            throw new ExistsException("Career Package Template does not exist");
        }
        Optional<OtherContributionsType> otherContributionsType = otherContrubutionsTypeRepository.findByDescription(otherContributionsRequirementDTO.getOtherContributionsType().getDescription());
        if(otherContributionsType.isEmpty()){
            throw new ExistsException("Other Contributions Type does not exist");
        }

        OtherContributionsRequirement updatedOtherContributionsRequirement = otherContributionsRequirement.get();
        updatedOtherContributionsRequirement.setCareerPackageTemplate(careerPackageTemplate.get());
        updatedOtherContributionsRequirement.setOtherContributionsType(otherContributionsType.get());
        updatedOtherContributionsRequirement.setAmountRequired(otherContributionsRequirementDTO.getAmountRequired());
        otherContributionsRequirementRepository.save(updatedOtherContributionsRequirement);
    }

    public OtherContributionsRequirementDTO getOtherContributionsRequirement(int id){
        Optional<OtherContributionsRequirement> otherContributionsRequirement = otherContributionsRequirementRepository.findById(id);
        if(otherContributionsRequirement.isEmpty()){
            throw new ExistsException("Other Contributions Requirement does not exist");
        }
        return otherContributionsRequirementMapper.otherContributionsRequirementToOtherContributionsRequirementDTO(otherContributionsRequirement.get());
    }

    public List<OtherContributionsRequirementDTO> getAllOtherContributionsRequirement(){
        List<OtherContributionsRequirement> otherContributionsRequirements = otherContributionsRequirementRepository.findAll();
        return otherContributionsRequirementMapper.otherContributionsRequirementListToOtherContributionsRequirementDTOList(otherContributionsRequirements);
    }
}
