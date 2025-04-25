package org.ms.adsfinal.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ms.adsfinal.dto.requestDto.AppointmentRequestDto;
import org.ms.adsfinal.dto.responseDto.AppointmentResponseDto;
import org.ms.adsfinal.service.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService service;

    @PostMapping
    public ResponseEntity<AppointmentResponseDto> create(@RequestBody @Valid AppointmentRequestDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<AppointmentResponseDto>> getAllAppointments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<AppointmentResponseDto> appointments = service.getAllAppointments(PageRequest.of(page, size));
        return ResponseEntity.ok(appointments);
    }


    //@GetMapping
    //public ResponseEntity<List<AppointmentResponseDto>> getAll() {
     //   return ResponseEntity.ok(service.getAll());
    //}
}