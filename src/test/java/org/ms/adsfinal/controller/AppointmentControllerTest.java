package org.ms.adsfinal.controller;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ms.adsfinal.dto.requestDto.AppointmentRequestDto;
import org.ms.adsfinal.dto.responseDto.AppointmentResponseDto;
import org.ms.adsfinal.service.AppointmentService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppointmentControllerTest {

    @Mock
    private AppointmentService appointmentService;

    @InjectMocks
    private AppointmentController appointmentController;

    @Test
    void shouldCreateAppointment() {
        // Given
        AppointmentRequestDto requestDto = new AppointmentRequestDto();
        requestDto.setDentistId(1);
        requestDto.setPatientId(2);
        requestDto.setSurgeryId(3);
        requestDto.setAppointmentDate(LocalDate.of(2025, 4, 25));
        requestDto.setAppointmentTime(LocalTime.of(10, 30));
        requestDto.setStatus("Scheduled");

        AppointmentResponseDto responseDto = new AppointmentResponseDto();
        responseDto.setDentistName("Dr. Smith");
        responseDto.setPatientName("John Doe");

        when(appointmentService.create(requestDto)).thenReturn(responseDto);

        // When
        ResponseEntity<AppointmentResponseDto> response = appointmentController.create(requestDto);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getDentistName()).isEqualTo("Dr. Smith");
        verify(appointmentService).create(requestDto);
    }

    @Test
    void shouldGetAllAppointments() {
        // Given
        AppointmentResponseDto dto1 = new AppointmentResponseDto();
        AppointmentResponseDto dto2 = new AppointmentResponseDto();
        when(appointmentService.getAll()).thenReturn(List.of(dto1, dto2));

        // When
        ResponseEntity<List<AppointmentResponseDto>> response = appointmentController.getAll();

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(2);
        verify(appointmentService).getAll();
    }
}
