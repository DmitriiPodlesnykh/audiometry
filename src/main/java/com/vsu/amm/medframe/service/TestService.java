package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.model.dto.CreateTestDto;
import com.vsu.amm.medframe.model.dto.PatientDto;
import com.vsu.amm.medframe.model.dto.TestDto;
import com.vsu.amm.medframe.model.dto.TestPointDto;

import java.util.List;

public interface TestService {

    CreateTestDto save(CreateTestDto test);

    TestDto getTestById(Long id);

    void deleteTest(Long id);

    List<TestDto> getAllPatientsTests(PatientDto patient);

    List<TestDto> getAll();

    TestPointDto save(TestPointDto testPointDto);

    TestPointDto getTestPointById(Long id);

    void deletePoint(Long id);

}
