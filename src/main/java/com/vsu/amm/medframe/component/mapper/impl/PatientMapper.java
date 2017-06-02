package com.vsu.amm.medframe.component.mapper.impl;

import com.vsu.amm.medframe.component.mapper.Mapper;
import com.vsu.amm.medframe.model.dto.PatientDto;
import com.vsu.amm.medframe.model.entity.Patient;
import com.vsu.amm.medframe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper implements Mapper<Patient, PatientDto> {

    @Autowired
    private final UserRepository userRepository;


    @Override
    public Patient mapToEntity(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setBirthday(patientDto.getBirthday());
        patient.setDescription(patientDto.getDescription());
        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setMiddleName(patientDto.getMiddleName());
        patient.setSex(patient.getSex());
        //patient.setTests();
        if (patientDto.getDoctorId() != null) {
            patient.setDoctor(userRepository.findById(patientDto.getDoctorId()));
        }
        if (patientDto.getId() != null) {
            patient.setId(patientDto.getId());
        }
        return patient;
    }

    @Override
    public PatientDto mapToDto(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setBirthday(patientDto.getBirthday());
        patientDto.setDescription(patientDto.getDescription());
        patientDto.setFirstName(patient.getFirstName());
        patientDto.setLastName(patient.getLastName());
        patientDto.setMiddleName(patient.getMiddleName());
        patientDto.setSex(patient.getSex());
        if(patient.getDoctor() != null) {
            patientDto.setDoctorId(patient.getDoctor().getId());
        }
        if(patient.getId() != null) {
            patientDto.setId(patientDto.getId());
        }
        //patientDto.tests
        return patientDto;
    }

    public PatientMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
