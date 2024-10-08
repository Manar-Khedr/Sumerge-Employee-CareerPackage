package org.example.Mappers;

import org.example.Classes.Competency;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetencyMapper {
    CompetencyDTO competencyToCompetencyDTO(Competency competency);
    Competency competencyDTOToComeptency(CompetencyDTO competencyDTO);
    List<CompetencyDTO> competencyListToCompetencyDTOList(List<Competency> competencies);
    List<Competency> competencyDTOListToCompetency(List<CompetencyDTO> competencyDTOS);
}
