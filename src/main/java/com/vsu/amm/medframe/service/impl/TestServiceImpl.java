package com.vsu.amm.medframe.service.impl;

import com.vsu.amm.medframe.component.mapper.impl.CreateTestDtoMapper;
import com.vsu.amm.medframe.component.mapper.impl.TestMapper;
import com.vsu.amm.medframe.model.dto.CreateTestRequest;
import com.vsu.amm.medframe.model.dto.PatientDto;
import com.vsu.amm.medframe.model.dto.TestResponse;
import com.vsu.amm.medframe.model.entity.Test;
import com.vsu.amm.medframe.repository.TestRepository;
import com.vsu.amm.medframe.service.TestService;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class TestServiceImpl implements TestService {

    private static final Logger LOGGER = Logger.getLogger(TestServiceImpl.class);

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestMapper testMapper;
    private final CreateTestDtoMapper createTestDtoMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public TestServiceImpl(CreateTestDtoMapper createTestDtoMapper) {
        this.createTestDtoMapper = createTestDtoMapper;
    }

    @Override
    public TestResponse save(CreateTestRequest requestDto) {
        Test test = modelMapper.map(requestDto, Test.class);
        if(test!=null) {
            LOGGER.info(test);
        }else {
            LOGGER.info("test is empty");
        }
        test = testRepository.save(test);
        if(test!=null) {
            LOGGER.info(test);
        }else {
            LOGGER.info("test is empty");
        }
        TestResponse testResponse = modelMapper.map(test, TestResponse.class);
        if(testResponse!=null) {
            LOGGER.info(testResponse);
        }else {
            LOGGER.info("testResponse is empty");
        }
        return testResponse;
    }

    @Override
    public TestResponse getTestById(Long id) {
        LOGGER.info("id = " + id.toString());
        return testMapper.mapToDto(testRepository.findOne(id));
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
        return testMapper.mapToDto(tests);
    }
}
