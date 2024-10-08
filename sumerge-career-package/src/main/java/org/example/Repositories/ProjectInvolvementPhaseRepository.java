package org.example.Repositories;

import org.example.Classes.ProjectInvolvementPhase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectInvolvementPhaseRepository extends JpaRepository<ProjectInvolvementPhase, Integer> {
}
