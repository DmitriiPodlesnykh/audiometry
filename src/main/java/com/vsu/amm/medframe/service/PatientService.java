package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.model.dto.PatientDto;

import java.util.List;

public interface PatientService {

    PatientDto save(PatientDto patientDto);

    List<PatientDto> getAll();

}
