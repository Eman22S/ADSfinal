package org.ms.adsfinal.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.ms.adsfinal.model.Bill;
import org.ms.adsfinal.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")  // ensures application-test.properties is used
class BillRepositoryTest {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    @DisplayName("Should fetch all bills for a patient from MySQL")
    void testFindByPatient() {
        // Arrange
        Patient patient = new Patient(null, "John", "Doe", "1234567890", "john@example.com",
                LocalDate.of(1990, 1, 1), "123 Main St");
        patient = patientRepository.save(patient);

        Bill bill1 = new Bill(null, patient, BigDecimal.valueOf(120.50), true);
        Bill bill2 = new Bill(null, patient, BigDecimal.valueOf(300.00), false);
        billRepository.saveAll(List.of(bill1, bill2));

        // Act
        List<Bill> result = billRepository.findByPatient(patient);

        // Assert
        assertThat(result).hasSize(2);
        assertThat(result).extracting(Bill::getAmount)
                .containsExactlyInAnyOrder(BigDecimal.valueOf(120.50), BigDecimal.valueOf(300.00));
    }
}
