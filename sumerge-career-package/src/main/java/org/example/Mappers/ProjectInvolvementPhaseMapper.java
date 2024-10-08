package org.example.Mappers;

import org.example.Classes.ProjectInvolvementPhase;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectInvolvementPhaseMapper {
    ProjectInvolvementPhaseDTO projectInvolvementPhaseToProjectInvolvementPhaseDTO(ProjectInvolvementPhase projectInvolvementPhase);
    ProjectInvolvementPhase projectInvolvementPhaseDTOToProjectInvolvementPhase(ProjectInvolvementPhaseDTO projectInvolvementPhaseDTO);
    List<ProjectInvolvementPhaseDTO> projectInvolvementPhaseListToProjectInvolvementPhaseDTOList(List<ProjectInvolvementPhase> projectInvolvementPhases);
    List<ProjectInvolvementPhase> projectInvolvementPhaseDTOListToProjectInvolvementPhaseList(List<ProjectInvolvementPhaseDTO> projectInvolvementDTOS);
}
