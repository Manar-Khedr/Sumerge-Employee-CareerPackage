package org.example.Services;

import org.example.Classes.Competency;
import org.example.Classes.CompetencyLevel;
import org.example.Exceptions.ExistsException;
import org.example.Mappers.CompetencyLevelDTO;
import org.example.Mappers.CompetencyLevelMapper;
import org.example.Repositories.CompetencyLevelRepository;
import org.example.Repositories.CompetencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetencyLevelService {

    private CompetencyLevelMapper competencyLevelMapper;
    private CompetencyLevelRepository competencyLevelRepository;
    private CompetencyRepository competencyRepository;

    public CompetencyLevelService(CompetencyLevelMapper competencyLevelMapper, CompetencyLevelRepository competencyLevelRepository, CompetencyRepository competencyRepository) {
        this.competencyLevelMapper = competencyLevelMapper;
        this.competencyLevelRepository = competencyLevelRepository;
        this.competencyRepository = competencyRepository;
    }

    public void createCompetencyLevel(CompetencyLevelDTO competencyLevelDTO){
        if(competencyLevelRepository.findById(competencyLevelDTO.getId()).isPresent()){
            throw new ExistsException("Competency Level already exists.");
        }
        if(competencyRepository.findByTitle(competencyLevelDTO.getCompetency().getTitle()).isEmpty()){
            throw new ExistsException("Competency does not exist");
        }
        Competency competency = competencyRepository.findByTitle(competencyLevelDTO.getCompetency().getTitle()).get();
        CompetencyLevel competencyLevel = competencyLevelMapper.competencyLevelDTOToCompetencyLevel(competencyLevelDTO);
        competencyLevel.setCompetency(competency);
        competencyLevelRepository.save(competencyLevel);
    }

    public void deleteCompetencyLevel(int id){
        Optional<CompetencyLevel> competencyLevel = competencyLevelRepository.findById(id);
        if(competencyLevel.isEmpty()){
            throw new ExistsException("Competency Level does not exist");
        }
        competencyLevelRepository.delete(competencyLevel.get());
    }

    public void updateCompetencyLevel(CompetencyLevelDTO competencyLevelDTO){
        Optional<CompetencyLevel> competencyLevel = competencyLevelRepository.findById(competencyLevelDTO.getId());
        if(competencyLevel.isEmpty()){
            throw new ExistsException("Competency Level does not exist");
        }
        Optional<Competency> competency = competencyRepository.findByTitle(competencyLevelDTO.getCompetency().getTitle());
        if(competency.isEmpty()){
            throw new ExistsException("Competency does not exist");
        }

        CompetencyLevel updatedCompetencyLevel = competencyLevel.get();
        updatedCompetencyLevel.setCompetency(competency.get());
        competencyLevelRepository.save(updatedCompetencyLevel);
    }

    public CompetencyLevelDTO getCompetencyLevel(int id){
        Optional<CompetencyLevel> competencyLevel = competencyLevelRepository.findById(id);
        if(competencyLevel.isEmpty()){
            throw new ExistsException("Competency Level does not exist");
        }
        return competencyLevelMapper.competencyLevelToCompetencyLevelDTO(competencyLevel.get());
    }

    public List<CompetencyLevelDTO> getAllCompetencyLevels(){
        List<CompetencyLevel> competencyLevelList = competencyLevelRepository.findAll();
        return competencyLevelMapper.competencyLevelListToCompetencyLevelDTOList(competencyLevelList);
    }
}
