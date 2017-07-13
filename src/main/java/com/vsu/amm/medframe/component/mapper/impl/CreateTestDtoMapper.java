package com.vsu.amm.medframe.component.mapper.impl;

import com.vsu.amm.medframe.component.mapper.Mapper;
import com.vsu.amm.medframe.model.dto.CreateTestRequest;
import com.vsu.amm.medframe.model.dto.TestPointResponse;
import com.vsu.amm.medframe.model.entity.Test;
import com.vsu.amm.medframe.model.entity.TestPoint;
import com.vsu.amm.medframe.repository.PatientRepository;
import com.vsu.amm.medframe.repository.TemplateRepository;
import com.vsu.amm.medframe.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.TreeSet;

@Component
public class CreateTestDtoMapper implements Mapper<Test, CreateTestRequest> {

    private final TestRepository testRepository;
    private final PatientRepository patientRepository;
    private final TemplateRepository templateRepository;
    private final TestPointMapper testPointMapper;

    @Override
    public Test mapToEntity(CreateTestRequest createTestRequest) {
        Test test = new Test();
        /*TODO: fix it
        if (createTestRequest.getTestId() != null) {
            test.setId(createTestRequest.getTestId());
        }*/
        if (createTestRequest.getPatientId() != null) {
            test.setPatient(patientRepository.findOne(createTestRequest.getPatientId()));
        }
        if (createTestRequest.getTemplateId() != null) {
            test.setTemplate(templateRepository.findOne(createTestRequest.getTemplateId()));
        }
        if (createTestRequest.getTestPoints() != null) {
            test.setTestPoints(mapDtoPointsToEntity((Set<TestPointResponse>) createTestRequest.getTestPoints()));
        }
        return test;
    }

    @Override
    public CreateTestRequest mapToDto(Test test) {
        CreateTestRequest createTestRequest = new CreateTestRequest();
        if (test.getPatient() != null) {
            createTestRequest.setPatientId(test.getPatient().getId());
        }
        createTestRequest.setTemplateId(test.getTemplate().getId());
        /*TODO: fix it
        createTestRequest.setTestId(test.getId());*/
        createTestRequest.setUserId(test.getPatient().getDoctor().getId());
        createTestRequest.setTestPoints(mapToDtoPoints(test.getTestPoints()));
        return createTestRequest;
    }

    private Set<TestPointResponse> mapToDtoPoints(Set<TestPoint> testPoints) {
        Set<TestPointResponse> testPointResponses = new TreeSet<TestPointResponse>();
        for (TestPoint point : testPoints) {
            TestPointResponse testPointResponse = testPointMapper.mapToDto(point);
            testPointResponses.add(testPointResponse);
        }
        return testPointResponses;
    }

    private Set<TestPoint> mapDtoPointsToEntity(Set<TestPointResponse> pointDtos) {
        Set<TestPoint> testPoints = new TreeSet<TestPoint>();
        for (TestPointResponse pointDto : pointDtos) {
            TestPoint point = testPointMapper.mapToEntity(pointDto);
            testPoints.add(point);
        }
        return testPoints;
    }

    @Autowired
    public CreateTestDtoMapper(TestRepository testRepository, PatientRepository patientRepository,
                               TemplateRepository templateRepository, TestPointMapper testPointMapper) {
        this.testRepository = testRepository;
        this.patientRepository = patientRepository;
        this.templateRepository = templateRepository;
        this.testPointMapper = testPointMapper;
    }
}
