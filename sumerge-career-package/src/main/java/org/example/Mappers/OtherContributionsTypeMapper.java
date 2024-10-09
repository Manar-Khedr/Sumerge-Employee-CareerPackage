package org.example.Mappers;

import org.example.Classes.OtherContributionsType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OtherContributionsTypeMapper {
    OtherContributionsTypeDTO otherContributionsTypeToOtherContributionsTypeDTO(OtherContributionsType otherContributionsType);
    OtherContributionsType otherContributionsTypeDTOToOtherContributionsType(OtherContributionsTypeDTO otherContributionsTypeDTO);
    List<OtherContributionsTypeDTO> otherContributionsTypeListToOtherContributionsTypeDTOList(List<OtherContributionsType> otherContributionsTypes);
    List<OtherContributionsType> otherContributionsTypeDTOListToOtherContributionsTypeList(List<OtherContributionsTypeDTO> otherContributionsTypeDTOS);
}
