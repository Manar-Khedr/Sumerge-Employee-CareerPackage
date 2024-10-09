package org.example.Mappers;

import org.example.Classes.ImprovementInitiatives;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImprovementInitiativesMapper {
    ImprovementInitiativesDTO improvementInitiativesToImprovementInitiativesDTO(ImprovementInitiatives improvementInitiatives);
    ImprovementInitiatives improvementInitiativesDTOToImprovementInitiatives(ImprovementInitiativesDTO improvementInitiativesDTO);
    List<ImprovementInitiativesDTO> improvementInitiativesListToImprovementInitiativesDTOList(List<ImprovementInitiatives> improvementInitiatives);
    List<ImprovementInitiatives> improvementInitiativesDTOListToImprovementInitiativesList(List<ImprovementInitiativesDTO> improvementInitiativesDTOS);
}
