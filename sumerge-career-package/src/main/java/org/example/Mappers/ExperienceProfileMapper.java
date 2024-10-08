package org.example.Mappers;

import org.example.Classes.ExperienceProfile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExperienceProfileMapper {
    ExperienceProfileDTO experienceProfileToExperienceProfileDTO(ExperienceProfile experienceProfile);
    ExperienceProfile experienceProfileDTOToExperienceProfile(ExperienceProfileDTO experienceProfileDTO);
    List<ExperienceProfileDTO> experienceProfileListToExperienceProfileDTO(List<ExperienceProfile> experienceProfileList);
    List<ExperienceProfile> experienceProfileDTOListToExperienceProfileList(List<ExperienceProfileDTO> experienceProfileDTOS);
}
