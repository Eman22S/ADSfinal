package org.ms.adsfinal.dto.requestDto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentRequestDto {
    private Integer dentistId;
    private Integer patientId;
    private Integer surgeryId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String status;
}