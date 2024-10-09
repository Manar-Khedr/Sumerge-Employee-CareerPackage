package org.example.Services;

import org.example.Classes.EmployeeCareerPackage;
import org.example.Classes.KnowledgeSharingSession;
import org.example.Exceptions.ExistsException;
import org.example.Mappers.KnowledgeSharingSessionDTO;
import org.example.Mappers.KnowledgeSharingSessionMapper;
import org.example.Repositories.EmployeeCareerPackageRepository;
import org.example.Repositories.KnowledgeSharingSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KnowledgeSharingSessionService {

    private final EmployeeCareerPackageRepository employeeCareerPackageRepository;
    private final KnowledgeSharingSessionRepository knowledgeSharingSessionRepository;
    private final KnowledgeSharingSessionMapper knowledgeSharingSessionMapper;

    public KnowledgeSharingSessionService(EmployeeCareerPackageRepository employeeCareerPackageRepository, KnowledgeSharingSessionRepository knowledgeSharingSessionRepository, KnowledgeSharingSessionMapper knowledgeSharingSessionMapper) {
        this.employeeCareerPackageRepository = employeeCareerPackageRepository;
        this.knowledgeSharingSessionRepository = knowledgeSharingSessionRepository;
        this.knowledgeSharingSessionMapper = knowledgeSharingSessionMapper;
    }

    public void createKnowledgeSharingSession(KnowledgeSharingSessionDTO knowledgeSharingSessionDTO){
        if(knowledgeSharingSessionRepository.findByTopic(knowledgeSharingSessionDTO.getTopic()).isPresent()){
            throw new ExistsException("Knowledge sharing session already exists");
        }
        Optional<EmployeeCareerPackage> employeeCareerPackage = employeeCareerPackageRepository.findByEmployeeId(knowledgeSharingSessionDTO.getEmployeeCareerPackage().getEmployeeId());
        if(employeeCareerPackage.isEmpty()){
            throw new ExistsException("Employee Career Package does not exist");
        }

        KnowledgeSharingSession knowledgeSharingSession = knowledgeSharingSessionMapper.knowledgeSharingSessionToKnowledgeSharingSessionDTO(knowledgeSharingSessionDTO);
        knowledgeSharingSession.setEmployeeCareerPackage(employeeCareerPackage.get());
        knowledgeSharingSessionRepository.save(knowledgeSharingSession);
    }

    public void deleteKnowledgeSharingSession(String topic){
        Optional<KnowledgeSharingSession> knowledgeSharingSession = knowledgeSharingSessionRepository.findByTopic(topic);
        if(knowledgeSharingSession.isEmpty()){
            throw new ExistsException("Knowledge Sharing Session does not exist");
        }
        knowledgeSharingSessionRepository.delete(knowledgeSharingSession.get());
    }

    public void updateKnowledgeSharingSession(KnowledgeSharingSessionDTO knowledgeSharingSessionDTO){
        Optional<KnowledgeSharingSession> knowledgeSharingSession = knowledgeSharingSessionRepository.findByTopic(knowledgeSharingSessionDTO.getTopic());
        if(knowledgeSharingSession.isEmpty()){
            throw new ExistsException("Knowledge Sharing Session does not exist");
        }
        Optional<EmployeeCareerPackage> employeeCareerPackage = employeeCareerPackageRepository.findByEmployeeId(knowledgeSharingSessionDTO.getEmployeeCareerPackage().getEmployeeId());
        if(employeeCareerPackage.isEmpty()){
            throw new ExistsException("Employee Career Package does not exist");
        }

        KnowledgeSharingSession updatedKnowledgeSharingSession = knowledgeSharingSession.get();
        updatedKnowledgeSharingSession.setEmployeeCareerPackage(employeeCareerPackage.get());
        updatedKnowledgeSharingSession.setDate(knowledgeSharingSessionDTO.getDate());
        updatedKnowledgeSharingSession.setFeedbackLink(knowledgeSharingSessionDTO.getFeedbackLink());
        updatedKnowledgeSharingSession.setProof(knowledgeSharingSessionDTO.getProof());
        updatedKnowledgeSharingSession.setTargetAudience(knowledgeSharingSessionDTO.getTargetAudience());
        updatedKnowledgeSharingSession.setFeedbackLink(knowledgeSharingSessionDTO.getFeedbackLink());
        knowledgeSharingSessionRepository.save(updatedKnowledgeSharingSession);
    }

    public KnowledgeSharingSessionDTO getKnowledgeSharingSession(String topic){
        Optional<KnowledgeSharingSession> knowledgeSharingSession = knowledgeSharingSessionRepository.findByTopic(topic);
        if(knowledgeSharingSession.isEmpty()){
            throw new ExistsException("Knowledge Sharing Session does not exist");
        }
        return knowledgeSharingSessionMapper.knowledgeSharingSessionToKnowledgeSharingSessionDTO(knowledgeSharingSession.get());
    }

    public List<KnowledgeSharingSessionDTO> getAllKnowledgeSharingSession(){
        List<KnowledgeSharingSession> knowledgeSharingSessions = knowledgeSharingSessionRepository.findAll();
        return knowledgeSharingSessionMapper.knowledgeSharingSessionListToKnowledgeSharingSessionDTOList(knowledgeSharingSessions);
    }
}
