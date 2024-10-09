package org.example.Services;

import org.example.Classes.OtherContributionsType;
import org.example.Exceptions.ExistsException;
import org.example.Mappers.OtherContributionsTypeDTO;
import org.example.Mappers.OtherContributionsTypeMapper;
import org.example.Repositories.OtherContrubutionsTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OtherContributionsTypeService {

    private OtherContributionsTypeMapper otherContributionsTypeMapper;
    private OtherContrubutionsTypeRepository otherContrubutionsTypeRepository;

    public OtherContributionsTypeService(OtherContrubutionsTypeRepository otherContrubutionsTypeRepository, OtherContributionsTypeMapper otherContributionsTypeMapper) {
        this.otherContrubutionsTypeRepository = otherContrubutionsTypeRepository;
        this.otherContributionsTypeMapper = otherContributionsTypeMapper;
    }

    public void createOtherContributionsType(OtherContributionsTypeDTO otherContributionsTypeDTO){
        if(otherContrubutionsTypeRepository.findByDescription(otherContributionsTypeDTO.getDescription()).isPresent()){
            throw new ExistsException("Other Contributions Type already exists");
        }
        otherContrubutionsTypeRepository.save(otherContributionsTypeMapper.otherContributionsTypeDTOToOtherContributionsType(otherContributionsTypeDTO));
    }

    public void deleteOtherContributionsType(int id){
        Optional<OtherContributionsType> otherContributionsType = otherContrubutionsTypeRepository.findById(id);
        if(otherContributionsType.isEmpty()){
            throw new ExistsException("Other Contributions Tyoe does not exist");
        }
        otherContrubutionsTypeRepository.delete(otherContributionsType.get());
    }

    public void updateOtherContributionsType(String description){
        Optional<OtherContributionsType> otherContributionsType = otherContrubutionsTypeRepository.findByDescription(description);
        if(otherContributionsType.isPresent()){
            throw new ExistsException("Other Contributions Type already exists");
        }
        OtherContributionsType updatedOtherContributionsType = otherContributionsType.get();
        updatedOtherContributionsType.setDescription(description);
        otherContrubutionsTypeRepository.save(updatedOtherContributionsType);
    }

    public OtherContributionsTypeDTO getOtherContributionsType(int id){
        Optional<OtherContributionsType> otherContributionsType = otherContrubutionsTypeRepository.findById(id);
        if(otherContributionsType.isEmpty()){
            throw new ExistsException("Other Contributions Tyoe does not exist");
        }
        return otherContributionsTypeMapper.otherContributionsTypeToOtherContributionsTypeDTO(otherContributionsType.get());
    }

    public List<OtherContributionsTypeDTO> getAllOtherContributionsType(){
        List<OtherContributionsType> otherContributionsTypes = otherContrubutionsTypeRepository.findAll();
        return otherContributionsTypeMapper.otherContributionsTypeListToOtherContributionsTypeDTOList(otherContributionsTypes);
    }
}
