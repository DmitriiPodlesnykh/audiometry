package com.vsu.amm.audiometry.service;

import com.vsu.amm.audiometry.model.dto.CreateTestRequest;
import com.vsu.amm.audiometry.model.dto.PatientDto;
import com.vsu.amm.audiometry.model.dto.TestResponse;
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
