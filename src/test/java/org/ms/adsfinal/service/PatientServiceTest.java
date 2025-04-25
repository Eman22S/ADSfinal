package org.ms.adsfinal.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ms.adsfinal.model.Patient;
import org.ms.adsfinal.repository.PatientRepository;
import org.ms.adsfinal.service.impl.PatientServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PatientServiceImplTest {

    private PatientRepository patientRepository;
    private PatientServiceImpl patientService;

    @BeforeEach
    void setUp() {
        patientRepository = mock(PatientRepository.class);
        patientService = new PatientServiceImpl(patientRepository);
    }

    @Test
    void testGetAllPatients() {
        List<Patient> mockPatients = Arrays.asList(
                new Patient("P101", "John", "Doe", "1234567890", "john@example.com", LocalDate.of(1990, 1, 1), "123 Street"),
                new Patient("P102", "Jane", "Smith", "9876543210", "jane@example.com", LocalDate.of(1985, 6, 15), "456 Avenue")
        );
        when(patientRepository.findAll()).thenReturn(mockPatients);

        List<Patient> patients = patientService.getAllPatients();
        assertEquals(2, patients.size());
        verify(patientRepository, times(1)).findAll();
    }

    @Test
    void testGetPatientById() {
        Patient patient = new Patient("P103", "Alice", "Johnson", "5555555555", "alice@example.com", LocalDate.of(1992, 4, 10), "789 Blvd");
        patient.setId(1);
        when(patientRepository.findById(1)).thenReturn(Optional.of(patient));

        Patient result = patientService.getPatientById(1);
        assertNotNull(result);
        assertEquals("Alice", result.getFirstName());
    }

    @Test
    void testCreatePatient() {
        Patient newPatient = new Patient("P104", "Bob", "Marley", "3333333333", "bob@example.com", LocalDate.of(1970, 3, 1), "123 Zion");
        when(patientRepository.save(any(Patient.class))).thenReturn(newPatient);

        Patient saved = patientService.createPatient(newPatient);
        assertEquals("Bob", saved.getFirstName());
        verify(patientRepository, times(1)).save(newPatient);
    }

    @Test
    void testDeletePatient() {
        patientService.deletePatient(1);
        verify(patientRepository, times(1)).deleteById(1);
    }
}
