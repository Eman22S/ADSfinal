package org.ms.adsfinal.dto.responseDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DentistResponseDto {
    private String firstName;
    private String lastName;
    private String specialization;
    private Integer id;

    public DentistResponseDto(int i, String tony, String smith, String general) {
    }
}