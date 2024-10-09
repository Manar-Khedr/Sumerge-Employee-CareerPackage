package org.example.Mappers;

import org.example.Classes.KnowledgeSharingSession;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KnowledgeSharingSessionMapper {
    KnowledgeSharingSessionDTO knowledgeSharingSessionToKnowledgeSharingSessionDTO(KnowledgeSharingSession knowledgeSharingSession);
    KnowledgeSharingSession knowledgeSharingSessionToKnowledgeSharingSessionDTO(KnowledgeSharingSessionDTO knowledgeSharingSessionDTO);
    List<KnowledgeSharingSessionDTO> knowledgeSharingSessionListToKnowledgeSharingSessionDTOList(List<KnowledgeSharingSession> knowledgeSharingSessions);
    List<KnowledgeSharingSession> knowledgeSharingSessionDTOListToKnowledgeSharingSessionList(List<KnowledgeSharingSessionDTO> knowledgeSharingSessionDTOS);

}
