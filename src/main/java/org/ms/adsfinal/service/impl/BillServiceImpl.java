package org.ms.adsfinal.service.impl;

import lombok.RequiredArgsConstructor;
import org.ms.adsfinal.model.Bill;
import org.ms.adsfinal.model.Patient;
import org.ms.adsfinal.repository.BillRepository;
import org.ms.adsfinal.repository.PatientRepository;
import org.ms.adsfinal.service.BillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final PatientRepository patientRepository;

    @Override
    public List<Bill> getBillsByPatientId(Integer patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        return billRepository.findByPatient(patient);
    }
}


