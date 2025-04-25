package org.ms.adsfinal.controller;

import org.junit.jupiter.api.Test;
import org.ms.adsfinal.model.Bill;
import org.ms.adsfinal.service.BillService;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class BillControllerTest {

    @Test
    void shouldReturnBillsForPatientId() throws Exception {
        BillService billService = mock(BillService.class);
        BillController controller = new BillController(billService);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        List<Bill> bills = List.of(new Bill(), new Bill());
        when(billService.getBillsByPatientId(1)).thenReturn(bills);

        mockMvc.perform(get("/api/bills/patient/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

        verify(billService).getBillsByPatientId(1);
    }
}
