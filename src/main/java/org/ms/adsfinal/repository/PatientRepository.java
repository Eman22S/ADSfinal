package org.ms.adsfinal.repository;

import org.ms.adsfinal.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {}
