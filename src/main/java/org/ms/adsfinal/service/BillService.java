package org.ms.adsfinal.service;


import org.ms.adsfinal.model.Bill;

import java.util.List;

public interface BillService {
    List<Bill> getBillsByPatientId(Integer patientId);
}

