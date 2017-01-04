package com.vsu.amm.medframe.service.Impl;

import com.vsu.amm.medframe.entity.Patient;
import com.vsu.amm.medframe.repository.PatientRepository;
import com.vsu.amm.medframe.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient editPatient(Patient patient) {
        return null;
    }

    @Override
    public void deletePatient(Long id) {

    }

    @Override
    public List<Patient> getAllPatientsOfTheDoctor(Long doctorId) {
        return patientRepository.findByDoctorId(doctorId);
    }
}
