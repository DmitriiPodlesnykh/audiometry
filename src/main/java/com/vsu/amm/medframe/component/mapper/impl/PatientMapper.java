package com.vsu.amm.medframe.component.mapper.impl;

import com.vsu.amm.medframe.component.mapper.Mapper;
import com.vsu.amm.medframe.dto.PatientDto;
import com.vsu.amm.medframe.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper implements Mapper<Patient, PatientDto> {
    @Override
    public Patient mapToEntity(PatientDto patientDto) {
        return null;
    }

    @Override
    public PatientDto mapToDto(Patient patient) {
        return null;
    }
}
