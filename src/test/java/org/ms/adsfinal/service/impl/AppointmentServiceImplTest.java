package org.ms.adsfinal.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ms.adsfinal.dto.requestDto.AppointmentRequestDto;
import org.ms.adsfinal.dto.responseDto.AppointmentResponseDto;
import org.ms.adsfinal.mapper.AppointmentMapper;
import org.ms.adsfinal.model.*;
import org.ms.adsfinal.repository.*;
import org.ms.adsfinal.service.impl.AppointmentServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppointmentServiceImplTest {

    @Mock private AppointmentRepository repo;
    @Mock private DentistRepository dentistRepo;
    @Mock private PatientRepository patientRepo;
    @Mock private SurgeryRepository surgeryRepo;
    @Mock private AppointmentMapper mapper;

    @InjectMocks private AppointmentServiceImpl service;

    @Test
    void shouldCreateAppointment() {
        AppointmentRequestDto dto = new AppointmentRequestDto();
        dto.setDentistId(1);
        dto.setPatientId(2);
        dto.setSurgeryId(3);
        dto.setAppointmentDate(LocalDate.of(2025, 4, 25));
        dto.setAppointmentTime(LocalTime.of(10, 30));
        dto.setStatus("Scheduled");

        Dentist d = new Dentist(1, "Tony", "Smith", "123", "tony@ads.com", "General");
        Patient p = new Patient("p10", "John", "Doe", "111", "john@example.com", LocalDate.of(1990, 1, 1), "123 Main");
        Surgery s = new Surgery(3, "S001", "Main Surgery", "123 Main", "999");

        Appointment a = new Appointment(d, p, s, dto.getAppointmentDate(), dto.getAppointmentTime(), dto.getStatus());
        AppointmentResponseDto responseDto = new AppointmentResponseDto();

        when(dentistRepo.findById(1)).thenReturn(Optional.of(d));
        when(patientRepo.findById(2)).thenReturn(Optional.of(p));
        when(surgeryRepo.findById(3)).thenReturn(Optional.of(s));
        when(mapper.toEntity(dto, d, p, s)).thenReturn(a);
        when(repo.save(a)).thenReturn(a);
        when(mapper.toDto(a)).thenReturn(responseDto);

        AppointmentResponseDto result = service.create(dto);

        assertThat(result).isNotNull();
        verify(dentistRepo).findById(1);
        verify(patientRepo).findById(2);
        verify(surgeryRepo).findById(3);
        verify(repo).save(a);
    }

    @Test
    void shouldReturnAllAppointments() {
        Appointment a = new Appointment();
        AppointmentResponseDto dto = new AppointmentResponseDto();

        when(repo.findAll()).thenReturn(List.of(a));
        when(mapper.toDto(a)).thenReturn(dto);

        List<AppointmentResponseDto> result = service.getAll();

        assertThat(result).hasSize(1);
        verify(repo).findAll();
    }
}
