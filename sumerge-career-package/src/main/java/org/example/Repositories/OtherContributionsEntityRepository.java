package org.example.Repositories;

import org.example.Classes.OtherContributionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherContributionsEntityRepository extends JpaRepository<OtherContributionsEntity, Integer> {
}
