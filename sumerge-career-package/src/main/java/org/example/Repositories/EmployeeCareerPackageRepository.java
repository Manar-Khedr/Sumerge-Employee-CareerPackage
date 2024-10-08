package org.example.Repositories;

import org.example.Classes.EmployeeCareerPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeCareerPackageRepository extends JpaRepository<EmployeeCareerPackage, Integer> {
    Optional<EmployeeCareerPackage> findByEmployeeId(int employeeId);
}
