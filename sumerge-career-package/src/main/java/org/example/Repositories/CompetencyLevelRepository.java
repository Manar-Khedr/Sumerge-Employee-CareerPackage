package org.example.Repositories;

import org.example.Classes.CompetencyLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetencyLevelRepository extends JpaRepository<CompetencyLevel, Integer> {
}
