package org.ms.adsfinal.service.impl;

import org.junit.jupiter.api.Test;
import org.ms.adsfinal.dto.requestDto.DentistRequestDto;
import org.ms.adsfinal.dto.responseDto.DentistResponseDto;
import org.ms.adsfinal.mapper.DentistMapper;
import org.ms.adsfinal.model.Dentist;
import org.ms.adsfinal.repository.DentistRepository;
import org.ms.adsfinal.service.DentistService;
import org.ms.adsfinal.service.impl.DentistServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DentistServiceTest {

    private final DentistRepository repository = mock(DentistRepository.class);
    private final DentistMapper mapper = new DentistMapper();
    private final DentistService service = new DentistServiceImpl(repository, mapper);

    @Test
    void shouldCreateDentist() {
        DentistRequestDto request = new DentistRequestDto();
        request.setFirstName("Amy");
        request.setLastName("Pond");
        request.setPhone("12345");
        request.setEmail("amy@example.com");
        request.setSpecialization("Orthodontics");

        when(repository.save(any())).thenAnswer(inv -> inv.getArgument(0));

        DentistResponseDto response = service.create(request);
        assertThat(response.getFirstName()).isEqualTo("Amy");
    }

    @Test
    void shouldReturnListOfDentists() {
        when(repository.findAll()).thenReturn(List.of(
                new Dentist(1, "Amy", "Pond", "123", "amy@example.com", "General"),
                new Dentist(2, "Rory", "Williams", "456", "rory@example.com", "Surgery")
        ));

        List<DentistResponseDto> list = service.getAll();
        assertThat(list).hasSize(2);
    }

    @Test
    void shouldReturnDentistById() {
        Dentist d = new Dentist(1, "Amy", "Pond", "123", "amy@example.com", "General");
        when(repository.findById(1)).thenReturn(Optional.of(d));

        DentistResponseDto dto = service.getById(1);
        assertThat(dto.getFirstName()).isEqualTo("Amy");
    }
}