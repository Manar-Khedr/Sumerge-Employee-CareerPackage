package org.example.Repositories;

import org.example.Classes.AdditionalReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalReferenceRepository extends JpaRepository<AdditionalReference, Integer> {
}
