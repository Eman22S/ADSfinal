package org.ms.adsfinal.repository;

import org.ms.adsfinal.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByLastNameContainingIgnoreCase(String searchString);

}
