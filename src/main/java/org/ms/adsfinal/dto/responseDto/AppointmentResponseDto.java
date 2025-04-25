package org.ms.adsfinal.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponseDto {
    private String dentistName;
    private String patientNo;
    private String patientName;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String surgeryNo;
}
