package org.example.Services;

import org.example.Classes.CareerPackageTemplate;
import org.example.Classes.OtherContributionsEntity;
import org.example.Classes.OtherContributionsType;
import org.example.Exceptions.ExistsException;
import org.example.Mappers.OtherContributionsEntityDTO;
import org.example.Mappers.OtherContributionsEntityMapper;
import org.example.Repositories.CareerPackageTemplateRepository;
import org.example.Repositories.OtherContributionsEntityRepository;
import org.example.Repositories.OtherContrubutionsTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OtherContributionsEntityService {

    private final OtherContributionsEntityMapper otherContributionsEntityMapper;
    private final OtherContributionsEntityRepository otherContributionsEntityRepository;
    private final CareerPackageTemplateRepository careerPackageTemplateRepository;
    private final OtherContrubutionsTypeRepository otherContrubutionsTypeRepository;

    public OtherContributionsEntityService(OtherContributionsEntityMapper otherContributionsEntityMapper, OtherContributionsEntityRepository otherContributionsEntityRepository, CareerPackageTemplateRepository careerPackageTemplateRepository, OtherContrubutionsTypeRepository otherContrubutionsTypeRepository) {
        this.otherContributionsEntityMapper = otherContributionsEntityMapper;
        this.otherContributionsEntityRepository = otherContributionsEntityRepository;
        this.careerPackageTemplateRepository = careerPackageTemplateRepository;
        this.otherContrubutionsTypeRepository = otherContrubutionsTypeRepository;
    }

    public void createOtherContributionsEntity(OtherContributionsEntityDTO otherContributionsEntityDTO){
        if(otherContributionsEntityRepository.findById(otherContributionsEntityDTO.getId()).isPresent()){
            throw new ExistsException("Other Contributions Entities already exists");
        }
        Optional<CareerPackageTemplate> careerPackageTemplate = careerPackageTemplateRepository.findByPositionTitle(otherContributionsEntityDTO.getCareerPackageTemplate().getPositionTitle());
        if(careerPackageTemplate.isEmpty()){
            throw new ExistsException("Career Package does not exist");
        }
        Optional<OtherContributionsType> otherContributionsType = otherContrubutionsTypeRepository.findById(otherContributionsEntityDTO.getOtherContributionsType().getId());
        if(otherContributionsType.isEmpty()){
            throw new ExistsException("Other Contributions Type does not exist");
        }

        OtherContributionsEntity otherContributionsEntity = otherContributionsEntityMapper.otherContributionsEntityDTOToOtherContributionsEntity(otherContributionsEntityDTO);
        otherContributionsEntity.setOtherContributionsType(otherContributionsType.get());
        otherContributionsEntity.setCareerPackageTemplate(careerPackageTemplate.get());
        otherContributionsEntityRepository.save(otherContributionsEntity);
    }

    public void deleteOtherContributionsEntity(int id){
        Optional<OtherContributionsEntity> otherContributionsEntity = otherContributionsEntityRepository.findById(id);
        if(otherContributionsEntity.isEmpty()){
            throw new ExistsException("Other Contributions Entity does not exist");
        }
        otherContributionsEntityRepository.delete(otherContributionsEntity.get());
    }

    public void updateOtherContributionsEntity(OtherContributionsEntityDTO otherContributionsEntityDTO){
        Optional<OtherContributionsEntity> otherContributionsEntity = otherContributionsEntityRepository.findById(otherContributionsEntityDTO.getId());
        if(otherContributionsEntity.isEmpty()){
            throw new ExistsException("Other Contributions Entity does not exist");
        }
        Optional<CareerPackageTemplate> careerPackageTemplate = careerPackageTemplateRepository.findByPositionTitle(otherContributionsEntityDTO.getCareerPackageTemplate().getPositionTitle());
        if(careerPackageTemplate.isEmpty()){
            throw new ExistsException("Career Package does not exist");
        }
        Optional<OtherContributionsType> otherContributionsType = otherContrubutionsTypeRepository.findById(otherContributionsEntityDTO.getOtherContributionsType().getId());
        if(otherContributionsType.isEmpty()){
            throw new ExistsException("Other Contributions Type does not exist");
        }

        OtherContributionsEntity updatedOtherContributionsEntity = otherContributionsEntity.get();
        updatedOtherContributionsEntity.setOtherContributionsType(otherContributionsType.get());
        updatedOtherContributionsEntity.setCareerPackageTemplate(careerPackageTemplate.get());
        updatedOtherContributionsEntity.setEntry(otherContributionsEntityDTO.getEntry());
        otherContributionsEntityRepository.save(updatedOtherContributionsEntity);
    }

    public OtherContributionsEntityDTO getOtherContributionsEntity(int id){
        Optional<OtherContributionsEntity> otherContributionsEntity = otherContributionsEntityRepository.findById(id);
        if(otherContributionsEntity.isEmpty()){
            throw new ExistsException("Other Contributions Entity does not exist");
        }
        return otherContributionsEntityMapper.otherContributionsEntityToOtherContributionsEntityDTO(otherContributionsEntity.get());
    }

    public List<OtherContributionsEntityDTO> getAllOtherContributionsEntity(){
        List<OtherContributionsEntity> otherContributionsEntities = otherContributionsEntityRepository.findAll();
        return otherContributionsEntityMapper.otherContributionsEntityListToOtherContributionsEntityDTOList(otherContributionsEntities);
    }
}
