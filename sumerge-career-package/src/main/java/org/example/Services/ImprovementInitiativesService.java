package org.example.Services;

import org.example.Classes.EmployeeCareerPackage;
import org.example.Classes.ImprovementInitiatives;
import org.example.Exceptions.ExistsException;
import org.example.Mappers.ImprovementInitiativesDTO;
import org.example.Mappers.ImprovementInitiativesMapper;
import org.example.Repositories.EmployeeCareerPackageRepository;
import org.example.Repositories.ImprovementInitiativesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImprovementInitiativesService {

    private final ImprovementInitiativesMapper improvementInitiativesMapper;
    private final ImprovementInitiativesRepository improvementInitiativesRepository;
    private final EmployeeCareerPackageRepository employeeCareerPackageRepository;

    public ImprovementInitiativesService(ImprovementInitiativesMapper improvementInitiativesMapper, ImprovementInitiativesRepository improvementInitiativesRepository, EmployeeCareerPackageRepository employeeCareerPackageRepository) {
        this.improvementInitiativesMapper = improvementInitiativesMapper;
        this.improvementInitiativesRepository = improvementInitiativesRepository;
        this.employeeCareerPackageRepository = employeeCareerPackageRepository;
    }

    public void createImprovementInitiatives(ImprovementInitiativesDTO improvementInitiativesDTO){
        if(improvementInitiativesRepository.findById(improvementInitiativesDTO.getId()).isPresent()){
            throw new ExistsException("Improvement Initiatives already exists");
        }
        Optional<EmployeeCareerPackage> employeeCareerPackage = employeeCareerPackageRepository.findByEmployeeId(improvementInitiativesDTO.getEmployeeCareerPackage().getEmployeeId());
        if(employeeCareerPackage.isEmpty()){
            throw new ExistsException("Employee Career Package does not exist");
        }
        ImprovementInitiatives improvementInitiatives = improvementInitiativesMapper.improvementInitiativesDTOToImprovementInitiatives(improvementInitiativesDTO);
        improvementInitiatives.setEmployeeCareerPackage(employeeCareerPackage.get());
        improvementInitiativesRepository.save(improvementInitiatives);
    }

    public void deleteImprovementInitiatives(int id){
        Optional<ImprovementInitiatives> improvementInitiatives = improvementInitiativesRepository.findById(id);
        if(improvementInitiatives.isEmpty()){
            throw new ExistsException("Improvement Initiatives does not exist");
        }
        improvementInitiativesRepository.delete(improvementInitiatives.get());
    }

    public void updateImprovementInitiatives(ImprovementInitiativesDTO improvementInitiativesDTO){
        Optional<ImprovementInitiatives> improvementInitiatives = improvementInitiativesRepository.findById(improvementInitiativesDTO.getId());
        if(improvementInitiatives.isEmpty()){
            throw new ExistsException("Improvement Initiatives does not exist");
        }
        Optional<EmployeeCareerPackage> employeeCareerPackage = employeeCareerPackageRepository.findByEmployeeId(improvementInitiativesDTO.getEmployeeCareerPackage().getEmployeeId());
        if(employeeCareerPackage.isEmpty()){
            throw new ExistsException("Employee Career Package does not exist");
        }
        ImprovementInitiatives updatedImprovementInitiatives = improvementInitiatives.get();
        updatedImprovementInitiatives.setEmployeeCareerPackage(employeeCareerPackage.get());
        updatedImprovementInitiatives.setBenificiaries(improvementInitiativesDTO.getBenificiaries());
        updatedImprovementInitiatives.setDescription(improvementInitiativesDTO.getDescription());
        updatedImprovementInitiatives.setProof(improvementInitiativesDTO.getProof());
        updatedImprovementInitiatives.setResult(improvementInitiativesDTO.getResult());
        improvementInitiativesRepository.save(updatedImprovementInitiatives);
    }

    public ImprovementInitiativesDTO getImprovementInitiatives(int id){
        Optional<ImprovementInitiatives> improvementInitiatives = improvementInitiativesRepository.findById(id);
        if(improvementInitiatives.isEmpty()){
            throw new ExistsException("Improvement Initiatives does not exist");
        }
        return improvementInitiativesMapper.improvementInitiativesToImprovementInitiativesDTO(improvementInitiatives.get());
    }

    public List<ImprovementInitiativesDTO> getAllImprovementInitiatives(){
        List<ImprovementInitiatives> improvementInitiatives = improvementInitiativesRepository.findAll();
        return improvementInitiativesMapper.improvementInitiativesListToImprovementInitiativesDTOList(improvementInitiatives);
    }
}
