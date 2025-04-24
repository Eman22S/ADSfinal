package org.ms.adsfinal;

import org.ms.adsfinal.model.Appointment;
import org.ms.adsfinal.model.Dentist;
import org.ms.adsfinal.model.Patient;
import org.ms.adsfinal.model.Surgery;
import org.ms.adsfinal.repository.AppointmentRepository;
import org.ms.adsfinal.repository.DentistRepository;
import org.ms.adsfinal.repository.PatientRepository;
import org.ms.adsfinal.repository.SurgeryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





/*@SpringBootApplication
public class AdsfinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdsfinalApplication.class, args);
    }

}*/



import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
public class AdsfinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdsfinalApplication.class, args);
    }

    @Bean
    CommandLineRunner seedAppointments(
            AppointmentRepository appointmentRepo,
            DentistRepository dentistRepo,
            PatientRepository patientRepo,
            SurgeryRepository surgeryRepo
    ) {
        return args -> {
            /*Dentist d1 = dentistRepo.findById(1).orElseThrow();
            Dentist d2 = dentistRepo.findById(2).orElseThrow();
            Dentist d3 = dentistRepo.findById(3).orElseThrow();

            Patient p1 = patientRepo.findById(1).orElseThrow();
            Patient p2 = patientRepo.findById(2).orElseThrow();
            Patient p3 = patientRepo.findById(3).orElseThrow();
            Patient p4 = patientRepo.findById(4).orElseThrow();

            Surgery s1 = surgeryRepo.findById(1).orElseThrow();
            Surgery s2 = surgeryRepo.findById(2).orElseThrow();
            Surgery s3 = surgeryRepo.findById(3).orElseThrow();


            Dentist d1 = dentistRepo.save(new Dentist("Tony", "Smith", "111-111-1111", "tony@ads.com", "General"));
            Patient p1 = patientRepo.save(new Patient("P100", "Gillian", "White", "444-444-4444", "gillian@example.com", "123 Elm", LocalDate.of(1980, 5, 1)));
            Surgery s1 = surgeryRepo.save(new Surgery("S15", "Surgery 15", "15 Park St", "888-111-1111"));
*/
            Dentist d1 = dentistRepo.save(new Dentist("Tony", "Smith", "111-111-1111", "tony@ads.com", "General"));
            Dentist d2 = dentistRepo.save(new Dentist("Helen", "Pearson", "222-222-2222", "helen@ads.com", "Oral Surgery"));
            Dentist d3 = dentistRepo.save(new Dentist("Robin", "Plevin", "333-333-3333", "robin@ads.com", "Orthodontics"));

            // 👉 Seed Patients
            Patient p1 = patientRepo.save(new Patient("P100", "Gillian", "White", "444-444-4444", "gillian@example.com",  LocalDate.of(1980, 5, 1), "100 Elm St"));
            Patient p2 = patientRepo.save(new Patient("P105", "Jill", "Bell", "555-555-5555", "jill@example.com",  LocalDate.of(1985, 7, 14), "200 Maple Ave"));
            Patient p3 = patientRepo.save(new Patient("P108", "Ian", "MacKay", "666-666-6666", "ian@example.com",  LocalDate.of(1978, 11, 22), "300 Oak Dr"));

            // 👉 Seed Surgeries
            Surgery s1 = surgeryRepo.save(new Surgery("S15", "Surgery 15", "15 Park St", "888-111-1111"));
            Surgery s2 = surgeryRepo.save(new Surgery("S10", "Surgery 10", "10 Main St", "888-222-2222"));
            Surgery s3 = surgeryRepo.save(new Surgery("S13", "Surgery 13", "13 Lake Rd", "888-333-3333"));

            appointmentRepo.saveAll(List.of(
                    new Appointment( d1, p1, s1, LocalDate.of(2023, 9, 12), LocalTime.of(10, 0), "confirmed"),
                    new Appointment( d1, p2, s1, LocalDate.of(2023, 9, 12), LocalTime.of(12, 0), "confirmed"),
                    new Appointment( d2, p3, s2, LocalDate.of(2023, 9, 12), LocalTime.of(10, 0), "confirmed"),
                    new Appointment( d2, p3, s2, LocalDate.of(2023, 9, 14), LocalTime.of(14, 0), "confirmed"),
                    new Appointment( d3, p2, s1, LocalDate.of(2023, 9, 14), LocalTime.of(16, 30), "confirmed")
            ));
        };
    }
}

