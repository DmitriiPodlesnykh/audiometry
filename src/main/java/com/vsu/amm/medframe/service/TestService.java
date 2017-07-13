package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.model.dto.CreateTestRequest;
import com.vsu.amm.medframe.model.dto.PatientDto;
import com.vsu.amm.medframe.model.dto.TestResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "testService")
public interface TestService {

    TestResponse save(CreateTestRequest test);

    TestResponse getTestById(Long id);

    void deleteTest(Long id);

    List<TestResponse> getAllPatientsTests(PatientDto patient);

    List<TestResponse> getAll();

}
