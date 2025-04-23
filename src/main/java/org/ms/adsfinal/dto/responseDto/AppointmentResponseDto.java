package org.ms.adsfinal.dto.responseDto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentResponseDto {
    private String dentistName;
    private String patientNo;
    private String patientName;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String surgeryNo;
}
