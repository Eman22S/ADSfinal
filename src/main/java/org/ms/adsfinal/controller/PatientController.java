package org.ms.adsfinal.controller;

import lombok.RequiredArgsConstructor;
import org.ms.adsfinal.model.Patient;
import org.ms.adsfinal.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    // 1. GET all patients sorted by last name
    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatientsSortedByLastName();
        return ResponseEntity.ok(patients);
    }

    // 2. GET patient by ID with exception handling
    @GetMapping("/patients/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable String id) {
        Patient patient = patientService.getPatientById(id);
        if (patient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient with ID " + id + " not found.");
        }
        return ResponseEntity.ok(patient);
    }

    // 3. POST - Register new patient
    @PostMapping("/patients")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.createPatient(patient), HttpStatus.CREATED);
    }

    // 4. PUT - Update patient by ID
    @PutMapping("/patient/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable String id, @RequestBody Patient updatedPatient) {
        Patient existing = patientService.getPatientById(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient with ID " + id + " not found.");
        }
        updatedPatient.setPatientId(id);
        return ResponseEntity.ok(patientService.createPatient(updatedPatient));
    }

    // 5. DELETE patient by ID
    @DeleteMapping("/patient/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable String id) {
        Patient existing = patientService.getPatientById(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient with ID " + id + " not found.");
        }
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully.");
    }

    // 6. Search by name (partial match)
    @GetMapping("/patient/search/{searchString}")
    public ResponseEntity<List<Patient>> searchPatients(@PathVariable String searchString) {
        return ResponseEntity.ok(patientService.searchPatients(searchString));
    }
}
