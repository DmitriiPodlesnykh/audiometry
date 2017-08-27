package com.vsu.amm.audiometry.service;

import com.vsu.amm.audiometry.model.dto.PatientDto;

import java.util.List;

public interface PatientService {

    PatientDto save(PatientDto patientDto);

    List<PatientDto> getAll();

}
