package org.example.Repositories;

import org.example.Classes.AdditionalReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdditionalReferenceRepository extends JpaRepository<AdditionalReference, Integer> {
    Optional<AdditionalReference> findByTitle(String title);
}
