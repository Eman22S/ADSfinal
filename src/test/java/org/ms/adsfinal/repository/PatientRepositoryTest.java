package org.ms.adsfinal.repository;

import org.junit.jupiter.api.Test;
import org.ms.adsfinal.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@ActiveProfiles("test")  // <- tells Spring to use application-test.properties
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PatientRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void testFindById() {
        Patient patient = new Patient("P100", "John", "Doe", "1234567890", "john@example.com", LocalDate.of(1990, 1, 1), "123 Main St");
        entityManager.persist(patient);
        Patient found = patientRepository.findById(patient.getId()).orElse(null);
        assertNotNull(found);
        assertEquals(patient.getFirstName(), found.getFirstName());
    }
}
