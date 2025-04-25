package org.ms.adsfinal.repository;

import org.junit.jupiter.api.Test;
import org.ms.adsfinal.model.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DentistRepositoryTest {

    @Autowired
    private DentistRepository dentistRepository;

    @Test
    void shouldSaveAndFindDentist() {
        Dentist dentist = new Dentist("John", "Doe", "1234567890", "john@example.com", "General");
        dentistRepository.save(dentist);

        List<Dentist> dentists = dentistRepository.findAll();
        assertThat(dentists).hasSize(1);
        assertThat(dentists.get(0).getFirstName()).isEqualTo("John");
    }
}