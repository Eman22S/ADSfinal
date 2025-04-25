package org.ms.adsfinal.service.impl;

import lombok.RequiredArgsConstructor;
import org.ms.adsfinal.model.Patient;
import org.ms.adsfinal.repository.PatientRepository;
import org.ms.adsfinal.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Integer id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }
    @Override
    public List<Patient> searchPatients(String searchString) {
        return patientRepository.findByFullNameContainingIgnoreCase(searchString);
    }
    @Override
    public List<Patient> getAllPatientsSortedByLastName() {
        return patientRepository.findAll().stream()
                .sorted((p1, p2) -> {
                    String lastName1 = p1.getLastName(); //p1.getFullName().trim().substring(p1.getFullName().lastIndexOf(" ") + 1).toLowerCase();
                    String lastName2 = p2.getLastName();//p2.getFullName().trim().substring(p2.getFullName().lastIndexOf(" ") + 1).toLowerCase();
                    return lastName1.compareTo(lastName2);
                })
                .toList();
    }


}
