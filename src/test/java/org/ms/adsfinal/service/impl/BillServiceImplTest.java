package  org.ms.adsfinal.service.impl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ms.adsfinal.model.Bill;
import org.ms.adsfinal.model.Patient;
import org.ms.adsfinal.repository.BillRepository;
import org.ms.adsfinal.repository.PatientRepository;
import org.ms.adsfinal.service.impl.BillServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BillServiceImplTest {

    private BillRepository billRepository;
    private PatientRepository patientRepository;
    private BillServiceImpl billService;

    @BeforeEach
    void setUp() {
        billRepository = mock(BillRepository.class);
        patientRepository = mock(PatientRepository.class);
        billService = new BillServiceImpl(billRepository, patientRepository);
    }

    @Test
    void shouldReturnBillsForExistingPatient() {
        Patient patient = new Patient("P10", "John", "Doe", "1234567890", "john@example.com", LocalDate.of(1990, 1, 1), "Address");
        List<Bill> bills = Arrays.asList(new Bill(), new Bill());

        when(patientRepository.findById(1)).thenReturn(Optional.of(patient));
        when(billRepository.findByPatient(patient)).thenReturn(bills);

        List<Bill> result = billService.getBillsByPatientId(1);

        assertEquals(2, result.size());
        verify(patientRepository).findById(1);
        verify(billRepository).findByPatient(patient);
    }

    @Test
    void shouldThrowExceptionIfPatientNotFound() {
        when(patientRepository.findById(999)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            billService.getBillsByPatientId(999);
        });

        assertEquals("Patient not found", ex.getMessage());
        verify(patientRepository).findById(999);
        verifyNoInteractions(billRepository);
    }
}
