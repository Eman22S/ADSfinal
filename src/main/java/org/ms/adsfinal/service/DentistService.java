package org.ms.adsfinal.service;

import org.ms.adsfinal.dto.requestDto.DentistRequestDto;
import org.ms.adsfinal.dto.responseDto.DentistResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DentistService {
    DentistResponseDto create(DentistRequestDto dto);
    List<DentistResponseDto> getAll();
    Page<DentistResponseDto> getAllDentists(Pageable pageable);
    DentistResponseDto getById(Integer id);
    void delete(Integer id);
}
