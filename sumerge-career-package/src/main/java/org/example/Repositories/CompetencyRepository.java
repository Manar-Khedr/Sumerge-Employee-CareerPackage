package org.example.Repositories;

import org.example.Classes.Competency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompetencyRepository extends JpaRepository<Competency, Integer> {
    Optional<Competency> findByTitle(String title);
}
