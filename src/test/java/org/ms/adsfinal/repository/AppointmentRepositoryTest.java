package org.ms.adsfinal.repository;

import org.junit.jupiter.api.Test;
import org.ms.adsfinal.model.Appointment;
import org.ms.adsfinal.model.Dentist;
import org.ms.adsfinal.model.Patient;
import org.ms.adsfinal.model.Surgery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class AppointmentRepositoryTest {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DentistRepository dentistRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SurgeryRepository surgeryRepository;

    @Test
    void shouldSaveAndFetchAppointments() {
        appointmentRepository.deleteAll();
        dentistRepository.deleteAll();
        patientRepository.deleteAll();
        surgeryRepository.deleteAll();

        Surgery surgery = surgeryRepository.save(new Surgery("S15", "Surgery 15", "15 Park St", "888-111-1111"));
        Patient patient = patientRepository.save(new Patient("P108", "Ian", "MacKay", "666-666-6666", "ian@example.com", LocalDate.of(1978, 11, 22), "300 Oak Dr"));
        Dentist dentist = dentistRepository.save(new Dentist("Robin", "Plevin", "333-333-3333", "robin@ads.com", "Orthodontics"));

        Appointment appointment = new Appointment(dentist, patient, surgery, LocalDate.now(), LocalTime.of(10, 30), "Scheduled");
        appointmentRepository.save(appointment);

        List<Appointment> result = appointmentRepository.findAll();
        assertThat(result).hasSize(1);
    }
}
