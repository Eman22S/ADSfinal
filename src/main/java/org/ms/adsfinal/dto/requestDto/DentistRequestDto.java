package org.ms.adsfinal.dto.requestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DentistRequestDto {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String specialization;
}