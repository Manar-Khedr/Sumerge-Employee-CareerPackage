package org.example.Repositories;

import org.example.Classes.OtherContributionsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtherContrubutionsTypeRepository extends JpaRepository<OtherContributionsType, Integer> {
    Optional<OtherContributionsType> findByDescription(String description);
}
