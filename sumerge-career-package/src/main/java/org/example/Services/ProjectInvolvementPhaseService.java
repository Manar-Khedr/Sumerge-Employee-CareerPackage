package org.example.Services;

import org.example.Classes.ExperienceProfile;
import org.example.Classes.ProjectInvolvementPhase;
import org.example.Exceptions.ExistsException;
import org.example.Mappers.ProjectInvolvementPhaseDTO;
import org.example.Mappers.ProjectInvolvementPhaseMapper;
import org.example.Repositories.ExperienceProfileRepository;
import org.example.Repositories.ProjectInvolvementPhaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectInvolvementPhaseService {

    private final ProjectInvolvementPhaseMapper projectInvolvementPhaseMapper;
    private final ProjectInvolvementPhaseRepository projectInvolvementPhaseRepository;
    private final ExperienceProfileRepository experienceProfileRepository;

    public ProjectInvolvementPhaseService(ProjectInvolvementPhaseMapper projectInvolvementPhaseMapper, ProjectInvolvementPhaseRepository projectInvolvementPhaseRepository, ExperienceProfileRepository experienceProfileRepository) {
        this.projectInvolvementPhaseMapper = projectInvolvementPhaseMapper;
        this.projectInvolvementPhaseRepository = projectInvolvementPhaseRepository;
        this.experienceProfileRepository = experienceProfileRepository;
    }

    public void createProjectInvolvementPhase(ProjectInvolvementPhaseDTO projectInvolvementDTO){
        if(projectInvolvementPhaseRepository.findById(projectInvolvementDTO.getId()).isPresent()){
            throw new ExistsException("Project Involvement Phase already exists");
        }
        Optional<ExperienceProfile> experienceProfile = experienceProfileRepository.findById(projectInvolvementDTO.getId());
        if(experienceProfile.isEmpty()){
            throw new ExistsException("Experience Profile does not exist");
        }

        ProjectInvolvementPhase projectInvolvementPhase = projectInvolvementPhaseMapper.projectInvolvementPhaseDTOToProjectInvolvementPhase(projectInvolvementDTO);
        projectInvolvementPhase.setExperienceProfile(experienceProfile.get());
        projectInvolvementPhaseRepository.save(projectInvolvementPhase);
    }

    public void deleteProjectPhaseInvolvementPhase(int id){
        Optional<ProjectInvolvementPhase> projectInvolvementPhase = projectInvolvementPhaseRepository.findById(id);
        if(projectInvolvementPhase.isEmpty()){
            throw new ExistsException("Project Involvement Phase does not exist");
        }
        projectInvolvementPhaseRepository.delete(projectInvolvementPhase.get());
    }

    public void updateProjectInvolvementPhase(ProjectInvolvementPhaseDTO projectInvolvementPhaseDTO){
        Optional<ProjectInvolvementPhase> projectInvolvementPhase = projectInvolvementPhaseRepository.findById(projectInvolvementPhaseDTO.getId());
        if(projectInvolvementPhase.isEmpty()){
            throw new ExistsException("Project Involvement Phase does not exist");
        }
        Optional<ExperienceProfile> experienceProfile = experienceProfileRepository.findById(projectInvolvementPhaseDTO.getId());
        if(experienceProfile.isEmpty()){
            throw new ExistsException("Experience Profile does not exist");
        }

        ProjectInvolvementPhase updatedProjectInvolvementPhase = projectInvolvementPhase.get();
        updatedProjectInvolvementPhase.setExperienceProfile(experienceProfile.get());
        updatedProjectInvolvementPhase.setPhaseCompletion(projectInvolvementPhaseDTO.getPhaseCompletion());
        updatedProjectInvolvementPhase.setPhaseDescription(projectInvolvementPhaseDTO.getPhaseDescription());
        updatedProjectInvolvementPhase.setPhaseStart(projectInvolvementPhaseDTO.getPhaseStart());
        projectInvolvementPhaseRepository.save(updatedProjectInvolvementPhase);
    }

    public ProjectInvolvementPhaseDTO getProjectInvolvementPhase(int id){
        Optional<ProjectInvolvementPhase> projectInvolvementPhase = projectInvolvementPhaseRepository.findById(id);
        if(projectInvolvementPhase.isEmpty()){
            throw new ExistsException("Project Involvement Phase does not exist");
        }
        return projectInvolvementPhaseMapper.projectInvolvementPhaseToProjectInvolvementPhaseDTO(projectInvolvementPhase.get());
    }

    public List<ProjectInvolvementPhaseDTO> getAllProjectInvolvementPhases(){
        List<ProjectInvolvementPhase> projectInvolvementPhases = projectInvolvementPhaseRepository.findAll();
        return projectInvolvementPhaseMapper.projectInvolvementPhaseListToProjectInvolvementPhaseDTOList(projectInvolvementPhases);
    }


}
