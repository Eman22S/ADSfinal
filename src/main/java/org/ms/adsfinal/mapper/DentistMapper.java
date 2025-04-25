package org.ms.adsfinal.mapper;

import org.ms.adsfinal.dto.requestDto.DentistRequestDto;
import org.ms.adsfinal.dto.responseDto.DentistResponseDto;
import org.ms.adsfinal.model.Dentist;
import org.springframework.stereotype.Component;

@Component
public class DentistMapper {

    public Dentist toEntity(DentistRequestDto dto) {
        return new Dentist(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getPhone(),
                dto.getEmail(),
                dto.getSpecialization()
        );
    }

    public DentistResponseDto toDto(Dentist dentist) {
        DentistResponseDto dto = new DentistResponseDto();
        dto.setFirstName(dentist.getFirstName());
        dto.setLastName(dentist.getLastName());
        dto.setId(dentist.getId());
        dto.setSpecialization(dentist.getSpecialization());
        return dto;
    }
}
