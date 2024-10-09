package org.example.Repositories;

import org.aspectj.apache.bcel.classfile.Module;
import org.example.Classes.KnowledgeSharingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KnowledgeSharingSessionRepository extends JpaRepository<KnowledgeSharingSession, Integer> {
    Optional<KnowledgeSharingSession> findByTopic(String topic);
}
