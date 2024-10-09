package org.example.Mappers;

import org.example.Classes.OtherContributionsEntity;
import org.example.Classes.OtherContributionsType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OtherContributionsEntityMapper {
    OtherContributionsEntityDTO otherContributionsEntityToOtherContributionsEntityDTO(OtherContributionsEntity otherContributionsEntity);
    OtherContributionsEntity otherContributionsEntityDTOToOtherContributionsEntity(OtherContributionsEntityDTO otherContributionsEntityDTO);
    List<OtherContributionsEntityDTO> otherContributionsEntityListToOtherContributionsEntityDTOList(List<OtherContributionsEntity> otherContributionsEntities);
    List<OtherContributionsEntity> otherContributionsEntityDTOListToOtherContributionsEntityList(List<OtherContributionsEntityDTO> otherContributionsEntityDTOS);
}
