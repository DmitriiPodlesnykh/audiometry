package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.entity.Patient;

public interface PatientService {
    Patient addPatient(Patient patient);
    Patient editPatient(Patient patient);
    void deletePatient(Long id);
}
