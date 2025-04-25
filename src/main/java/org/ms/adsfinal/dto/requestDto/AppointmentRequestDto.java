package org.ms.adsfinal.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequestDto {
    private Integer dentistId;
    private Integer patientId;
    private Integer surgeryId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String status;
}