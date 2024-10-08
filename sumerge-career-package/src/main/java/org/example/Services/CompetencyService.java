package org.example.Services;

import org.example.Classes.Competency;
import org.example.Enums.CompetencyType;
import org.example.Exceptions.ExistsException;
import org.example.Mappers.CompetencyDTO;
import org.example.Mappers.CompetencyMapper;
import org.example.Repositories.CompetencyRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CompetencyService {

    private CompetencyMapper competencyMapper;
    private CompetencyRepository competencyRepository;
    private CompetencyType competencyType;

    public CompetencyService(CompetencyMapper competencyMapper, CompetencyRepository competencyRepository) {
        this.competencyMapper = competencyMapper;
        this.competencyRepository = competencyRepository;
    }

    public void createCompetency(CompetencyDTO competencyDTO){
        if(competencyRepository.findByTitle(competencyDTO.getTitle()).isPresent()){
            throw new ExistsException("Competency already exists");
        }
        if(competencyDTO.getType() != competencyType.FUNCTIONAL && competencyDTO.getType() != competencyType.ORGANISATIONAL){
            throw new ExistsException("Competency Type does not exist");
        }
        competencyRepository.save(competencyMapper.competencyDTOToComeptency(competencyDTO));
    }

    public void deleteCompetency(String title){
        Optional<Competency> competency = competencyRepository.findByTitle(title);
        if(competency.isEmpty()){
            throw new ExistsException("Competency does not exist");
        }
        competencyRepository.delete(competency.get());
    }

    public void updateCompetency(CompetencyDTO competencyDTO){
        Optional<Competency> competency = competencyRepository.findByTitle(competencyDTO.getTitle());
        if(competency.isEmpty()){
            throw new ExistsException("Competency does not exist");
        }
        if(competencyDTO.getType() != competencyType.FUNCTIONAL && competencyDTO.getType() != competencyType.ORGANISATIONAL){
            throw new ExistsException("Competency Type does not exist");
        }

        Competency updatedCompetency = competency.get();
        updatedCompetency.setDefinition(competencyDTO.getDefinition());
        updatedCompetency.setType(competencyDTO.getType());
        competencyRepository.save(updatedCompetency);
    }

    public CompetencyDTO getCompetency(String title){
        Optional<Competency> competency = competencyRepository.findByTitle(title);
        if(competency.isEmpty()){
            throw new ExistsException("Competency does not exist");
        }
        return competencyMapper.competencyToCompetencyDTO(competency.get());
    }

    public List<CompetencyDTO> getAllCompetencies(){
        List<Competency> competencies = competencyRepository.findAll();
        return competencyMapper.competencyListToCompetencyDTOList(competencies);
    }
}
