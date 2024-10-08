package org.example.Mappers;

import org.example.Classes.AdditionalReference;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( componentModel = "spring")
public interface AdditionalReferenceMapper {

    AdditionalReferenceDTO additionalReferenceToAdditonalReferenceDTO(AdditionalReference additionalReference);
    AdditionalReference additionalReferenceDTOToAdditionalReference(AdditionalReferenceDTO additionalReferenceDTO);
    List<AdditionalReferenceDTO> additionalReferenceListToAdditonalReferenceDTOList(List<AdditionalReference> additionalReferences);
    List<AdditionalReference> additionalReferenceDTOListToAdditionalReferenceList(List<AdditionalReferenceDTO> additionalReferenceDTOS);
}
