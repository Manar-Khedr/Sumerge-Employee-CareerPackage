package org.example.Repositories;

import org.example.Classes.ImprovementInitiatives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImprovementInitiativesRepository extends JpaRepository<ImprovementInitiatives, Integer> {
}
