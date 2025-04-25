package org.ms.adsfinal.service.impl;

import lombok.RequiredArgsConstructor;
import org.ms.adsfinal.dto.requestDto.DentistRequestDto;
import org.ms.adsfinal.dto.responseDto.DentistResponseDto;
import org.ms.adsfinal.exception.ResourceNotFoundException;
import org.ms.adsfinal.mapper.DentistMapper;
import org.ms.adsfinal.model.Dentist;
import org.ms.adsfinal.repository.DentistRepository;
import org.ms.adsfinal.service.DentistService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DentistServiceImpl implements DentistService {

    private final DentistRepository repository;
    private final DentistMapper mapper;

    @Override
    public DentistResponseDto create(DentistRequestDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public List<DentistResponseDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
    @Override
    public Page<DentistResponseDto> getAllDentists(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDto);
    }

    @Override
    public DentistResponseDto getById(Integer id) {
        Dentist dentist = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dentist not found with id: " + id));
        return mapper.toDto(dentist);
    }

    @Override
    public void delete(Integer id) {
        Dentist dentist = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dentist not found with id: " + id));
        repository.delete(dentist);
    }
}
