package com.vsu.amm.audiometry.service.impl;

import com.vsu.amm.audiometry.mapper.TestMapper;
import com.vsu.amm.audiometry.model.dto.CreateTestRequest;
import com.vsu.amm.audiometry.model.dto.PatientDto;
import com.vsu.amm.audiometry.model.dto.TestResponse;
import com.vsu.amm.audiometry.model.entity.Test;
import com.vsu.amm.audiometry.repository.TestRepository;
import com.vsu.amm.audiometry.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestServiceImpl implements TestService {

    private static final Logger LOGGER = Logger.getLogger(TestServiceImpl.class);

    @Autowired
    private TestRepository testRepository;

    @Override
    public TestResponse save(CreateTestRequest requestDto) {
        Test test = TestMapper.INSTANCE.mapToEntity(requestDto);
                //modelMapper.map(requestDto, Test.class);
        if (test != null) {
            LOGGER.info(test);
        } else {
            LOGGER.info("test is empty");
        }
        test = testRepository.save(test);
        if (test != null) {
            LOGGER.info(test);
        } else {
            LOGGER.info("test is empty");
        }
        TestResponse testResponse = TestMapper.INSTANCE.toTestResponse(test);
        if (testResponse != null) {
            LOGGER.info(testResponse);
        } else {
            LOGGER.info("testResponse is empty");
        }
        return testResponse;
    }

    @Override
    public TestResponse getTestById(Long id) {
        LOGGER.info("id = " + id.toString());
        return TestMapper.INSTANCE.toTestResponse(testRepository.findOne(id));
    }

    @Override
    public void deleteTest(Long id) {

    }

    @Override
    public List<TestResponse> getAllPatientsTests(PatientDto patient) {
        return null;
    }

    @Override
    public List<TestResponse> getAll() {
        List<Test> tests = testRepository.findAll();
        //return testMapper.mapToDto(tests);
        //todo fix it
        return null;
    }
}
