package org.ms.adsfinal.service;

import org.ms.adsfinal.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    Patient getPatientById(Integer id);
    Patient createPatient(Patient patient);
    void deletePatient(Integer id);
    List<Patient> searchPatients(String searchString);
    List<Patient> getAllPatientsSortedByLastName();


}