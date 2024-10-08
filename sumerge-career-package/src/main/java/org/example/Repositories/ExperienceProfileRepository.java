package org.example.Repositories;

import org.example.Classes.ExperienceProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceProfileRepository extends JpaRepository<ExperienceProfile, Integer> {
}
