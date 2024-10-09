package org.example.Repositories;

import org.example.Classes.OtherContributionsRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherContributionsRequirementRepository extends JpaRepository<OtherContributionsRequirement, Integer> {
}
