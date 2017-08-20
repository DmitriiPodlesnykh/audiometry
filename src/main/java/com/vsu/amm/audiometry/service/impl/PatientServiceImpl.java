package com.vsu.amm.audiometry.service.impl;

import com.vsu.amm.audiometry.mapper.PatientMapper;
import com.vsu.amm.audiometry.model.dto.PatientDto;
import com.vsu.amm.audiometry.model.entity.Patient;
import com.vsu.amm.audiometry.repository.PatientRepository;
import com.vsu.amm.audiometry.service.PatientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private static final Logger LOGGER = Logger.getLogger(PatientServiceImpl.class);

    private final PatientRepository patientRepository;
    private final UserServiceImpl userService;

    @Autowired
    PatientServiceImpl(PatientRepository patientRepository, UserServiceImpl userService) {
        this.patientRepository = patientRepository;
        this.userService = userService;
    }

    @Override
    public PatientDto save(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setMiddleName(patientDto.getMiddleName());
        patient.setSex(patientDto.getSex());
        patient.setDescription(patientDto.getDescription());
        //patient.setDoctor(userService.getOne(patientDto.getDoctorId()));
        patient = patientRepository.save(patient);
        return PatientMapper.INSTANCE.toPatientDto(patient);
    }

    @Override
    public List<PatientDto> getAll() {
        LOGGER.info("getAll");
        List<Patient> patients = patientRepository.findAll();
        LOGGER.info("patients. size = " + patients.size());

        List<PatientDto> patientsDto = new ArrayList<PatientDto>();
        for (Patient patient : patientRepository.findAll()) {
            PatientDto patientDto = PatientMapper.INSTANCE.toPatientDto(patient);
            LOGGER.info("patient = " + patient.toString() + " ; + patientDto = " + patientDto.toString());
            patientsDto.add(patientDto);
        }
        LOGGER.info("before return patientsDto = " + patientsDto.toString());
        return patientsDto;
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
