package org.ms.adsfinal.repository;


import org.ms.adsfinal.model.Bill;
import org.ms.adsfinal.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    List<Bill> findByPatient(Patient patient);
}
