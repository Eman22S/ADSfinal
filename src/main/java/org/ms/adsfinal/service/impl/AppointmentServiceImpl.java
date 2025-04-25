package org.ms.adsfinal.service.impl;


import lombok.RequiredArgsConstructor;
import org.ms.adsfinal.dto.requestDto.AppointmentRequestDto;
import org.ms.adsfinal.dto.responseDto.AppointmentResponseDto;
import org.ms.adsfinal.exception.ResourceNotFoundException;
import org.ms.adsfinal.mapper.AppointmentMapper;
import org.ms.adsfinal.model.Appointment;
import org.ms.adsfinal.model.Dentist;
import org.ms.adsfinal.model.Patient;
import org.ms.adsfinal.model.Surgery;
import org.ms.adsfinal.repository.AppointmentRepository;
import org.ms.adsfinal.repository.DentistRepository;
import org.ms.adsfinal.repository.PatientRepository;
import org.ms.adsfinal.repository.SurgeryRepository;
import org.ms.adsfinal.service.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repo;
    private final DentistRepository dentistRepo;
    private final PatientRepository patientRepo;
    private final SurgeryRepository surgeryRepo;
    private final AppointmentMapper mapper;

    @Override
    public AppointmentResponseDto create(AppointmentRequestDto dto) {
        Dentist d = dentistRepo.findById(dto.getDentistId()).orElseThrow(() -> new ResourceNotFoundException("Dentist not found"));
        Patient p = patientRepo.findById(dto.getPatientId()).orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        Surgery s = surgeryRepo.findById(dto.getSurgeryId()).orElseThrow(() -> new ResourceNotFoundException("Surgery not found"));
        Appointment a = mapper.toEntity(dto, d, p, s);
        return mapper.toDto(repo.save(a));
    }
    @Override
    public Page<AppointmentResponseDto> getAllAppointments(Pageable pageable) {
        return repo.findAll(pageable)
                .map(mapper::toDto);
    }



}