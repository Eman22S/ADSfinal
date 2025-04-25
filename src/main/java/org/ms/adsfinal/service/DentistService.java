package org.ms.adsfinal.service;

import org.ms.adsfinal.dto.requestDto.DentistRequestDto;
import org.ms.adsfinal.dto.responseDto.DentistResponseDto;

import java.util.List;

public interface DentistService {
    DentistResponseDto create(DentistRequestDto dto);
    List<DentistResponseDto> getAll();
    DentistResponseDto getById(Integer id);
    void delete(Integer id);
}
