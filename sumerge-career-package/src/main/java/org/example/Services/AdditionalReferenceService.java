package org.example.Services;

import org.example.Classes.AdditionalReference;
import org.example.Classes.EmployeeCareerPackage;
import org.example.Exceptions.ExistsException;
import org.example.Mappers.AdditionalReferenceDTO;
import org.example.Mappers.AdditionalReferenceMapper;
import org.example.Repositories.AdditionalReferenceRepository;
import org.example.Repositories.EmployeeCareerPackageRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AdditionalReferenceService {

    private final AdditionalReferenceMapper additionalReferenceMapper;
    private final AdditionalReferenceRepository additionalReferenceRepository;
    private final EmployeeCareerPackageRepository employeeCareerPackageRepository;

    public AdditionalReferenceService(AdditionalReferenceMapper additionalReferenceMapper, AdditionalReferenceRepository additionalReferenceRepository, EmployeeCareerPackageRepository employeeCareerPackageRepository) {
        this.additionalReferenceMapper = additionalReferenceMapper;
        this.additionalReferenceRepository = additionalReferenceRepository;
        this.employeeCareerPackageRepository = employeeCareerPackageRepository;
    }

    public void createAdditionalReference(AdditionalReferenceDTO additionalReferenceDTO){
        if(additionalReferenceRepository.findByTitle(additionalReferenceDTO.getTitle()).isPresent()){
            throw new ExistsException("Additional Reference already exists");
        }
        Optional<EmployeeCareerPackage> employeeCareerPackage = employeeCareerPackageRepository.findByEmployeeId(additionalReferenceDTO.getEmployeeCareerPackage().getEmployeeId());
        if(employeeCareerPackage.isEmpty()){
            throw new ExistsException("Employee Career Package does not exist");
        }

        AdditionalReference additionalReference = additionalReferenceMapper.additionalReferenceDTOToAdditionalReference(additionalReferenceDTO);
        additionalReference.setEmployeeCareerPackage(employeeCareerPackage.get());
        additionalReferenceRepository.save(additionalReference);
    }

    public void deleteAdditionalReference(String title){
        Optional<AdditionalReference> additionalReference = additionalReferenceRepository.findByTitle(title);
        if(additionalReference.isEmpty()){
            throw new ExistsException("Additional Reference does not exist");
        }
        additionalReferenceRepository.delete(additionalReference.get());
    }

    public void updateAdditonalReference(AdditionalReferenceDTO additionalReferenceDTO){
        Optional<AdditionalReference> additionalReference = additionalReferenceRepository.findByTitle(additionalReferenceDTO.getTitle());
        if(additionalReference.isEmpty()){
            throw new ExistsException("Additional Reference does not exist");
        }
        Optional<EmployeeCareerPackage> employeeCareerPackage = employeeCareerPackageRepository.findByEmployeeId(additionalReferenceDTO.getEmployeeCareerPackage().getEmployeeId());
        if(employeeCareerPackage.isEmpty()){
            throw new ExistsException("Employee Career Package does not exist");
        }

        AdditionalReference updatedAdditionalReference = additionalReference.get();
        updatedAdditionalReference.setEmployeeCareerPackage(employeeCareerPackage.get());
        updatedAdditionalReference.setDescription(additionalReferenceDTO.getDescription());
        additionalReferenceRepository.save(updatedAdditionalReference);
    }

    public AdditionalReferenceDTO getAdditionalReference(String title){
        Optional<AdditionalReference> additionalReference = additionalReferenceRepository.findByTitle(title);
        if(additionalReference.isEmpty()){
            throw new ExistsException("Additional Reference does not exist");
        }
        return additionalReferenceMapper.additionalReferenceToAdditonalReferenceDTO(additionalReference.get());
    }

    public List<AdditionalReferenceDTO> getAllAdditionalReference(){
        List<AdditionalReference> additionalReferences = additionalReferenceRepository.findAll();
        return additionalReferenceMapper.additionalReferenceListToAdditonalReferenceDTOList(additionalReferences);
    }
}
