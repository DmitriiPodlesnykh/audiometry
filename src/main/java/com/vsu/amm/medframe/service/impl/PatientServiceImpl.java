package com.vsu.amm.medframe.service.impl;

import com.vsu.amm.medframe.component.mapper.impl.PatientMapper;
import com.vsu.amm.medframe.dto.PatientDto;
import com.vsu.amm.medframe.entity.Patient;
import com.vsu.amm.medframe.repository.PatientRepository;
import com.vsu.amm.medframe.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PatientMapper patientMapper;

    public PatientDto save(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setMiddleName(patientDto.getMiddleName());
        patient.setSex(patientDto.getSex());
        patient.setDescription(patientDto.getDescription());
        //patient.setDoctor(userService.getOne(patientDto.getDoctorId()));
        patient = patientRepository.save(patient);
        return patientMapper.mapToDto(patient);
    }

    public Patient editPatient(Patient patient) {
        return null;
    }

    public void deletePatient(Long id) {
    }

    public List<Patient> getAllPatientsOfTheDoctor(Long doctorId) {
        return patientRepository.findByDoctorId(doctorId);
    }
}
