package org.ms.adsfinal.service;

import org.ms.adsfinal.dto.requestDto.AppointmentRequestDto;
import org.ms.adsfinal.dto.responseDto.AppointmentResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AppointmentService {
    AppointmentResponseDto create(AppointmentRequestDto dto);
   // List<AppointmentResponseDto> getAll();
   Page<AppointmentResponseDto> getAllAppointments(Pageable pageable);

}