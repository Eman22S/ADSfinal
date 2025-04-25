package org.ms.adsfinal.controller;

import lombok.RequiredArgsConstructor;
import org.ms.adsfinal.model.Bill;
import org.ms.adsfinal.service.BillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @GetMapping("/patient/{patientId}")
    public List<Bill> getBillsByPatient(@PathVariable Integer patientId) {
        return billService.getBillsByPatientId(patientId);
    }
}

