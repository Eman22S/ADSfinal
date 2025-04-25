package org.ms.adsfinal.controller;

import lombok.RequiredArgsConstructor;
import org.ms.adsfinal.dto.requestDto.DentistRequestDto;
import org.ms.adsfinal.dto.responseDto.DentistResponseDto;
import org.ms.adsfinal.service.DentistService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dentists")
@RequiredArgsConstructor
public class DentistController {

    private final DentistService service;

    @PostMapping
    public ResponseEntity<DentistResponseDto> create(@RequestBody DentistRequestDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DentistResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping
    public ResponseEntity<Page<DentistResponseDto>> getAllDentists(
            @PageableDefault(size = 10) Pageable pageable) {
        Page<DentistResponseDto> dentists = service.getAllDentists(pageable);
        return ResponseEntity.ok(dentists);
    }




    @GetMapping("/{id}")
    public ResponseEntity<DentistResponseDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}