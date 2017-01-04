package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient save(Patient patient);
    Patient editPatient(Patient patient);
    void deletePatient(Long id);
    List<Patient> getAllPatientsOfTheDoctor(Long doctorId);
}
