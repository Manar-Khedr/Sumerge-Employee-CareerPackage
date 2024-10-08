package org.example.Mappers;

import org.example.Classes.CompetencyLevel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetencyLevelMapper {
    CompetencyLevelDTO competencyLevelToCompetencyLevelDTO(CompetencyLevel competencyLevel);
    CompetencyLevel competencyLevelDTOToCompetencyLevel(CompetencyLevelDTO competencyLevelDTO);
    List<CompetencyLevelDTO> competencyLevelListToCompetencyLevelDTOList(List<CompetencyLevel> competencyLevelList);
    List<CompetencyLevel> competencyLevelDTOToComoetencyLevelList(List<CompetencyLevelDTO> competencyLevelDTOS);
}
