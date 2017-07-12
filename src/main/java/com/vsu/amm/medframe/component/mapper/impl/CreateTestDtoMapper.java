package com.vsu.amm.medframe.component.mapper.impl;

import com.vsu.amm.medframe.component.mapper.Mapper;
import com.vsu.amm.medframe.model.dto.CreateTestDto;
import com.vsu.amm.medframe.model.dto.TestPointDto;
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
public class CreateTestDtoMapper implements Mapper<Test, CreateTestDto> {

    private final TestRepository testRepository;
    private final PatientRepository patientRepository;
    private final TemplateRepository templateRepository;
    private final TestPointMapper testPointMapper;

    @Override
    public Test mapToEntity(CreateTestDto createTestDto) {
        Test test = new Test();

        if (createTestDto.getTestId() != null) {
            test.setId(createTestDto.getTestId());
        }
        if (createTestDto.getPatientId() != null) {
            test.setPatient(patientRepository.findOne(createTestDto.getPatientId()));
        }
        if (createTestDto.getTemplateId() != null) {
            test.setTemplate(templateRepository.findOne(createTestDto.getTemplateId()));
        }
        if (createTestDto.getTestPoins() != null) {
            test.setTestPoints(mapDtoPointsToEntity((Set<TestPointDto>) createTestDto.getTestPoins()));
        }
        return test;
    }

    @Override
    public CreateTestDto mapToDto(Test test) {
        CreateTestDto createTestDto = new CreateTestDto();
        if (test.getPatient() != null) {
            createTestDto.setPatientId(test.getPatient().getId());
        }
        createTestDto.setTemplateId(test.getTemplate().getId());
        createTestDto.setTestId(test.getId());
        createTestDto.setUserId(test.getPatient().getDoctor().getId());
        createTestDto.setTestPoins(mapToDtoPoints(test.getTestPoints()));
        return createTestDto;
    }

    private Set<TestPointDto> mapToDtoPoints(Set<TestPoint> testPoints) {
        Set<TestPointDto> testPointDtos = new TreeSet<TestPointDto>();
        for (TestPoint point : testPoints) {
            TestPointDto testPointDto = testPointMapper.mapToDto(point);
            testPointDtos.add(testPointDto);
        }
        return testPointDtos;
    }

    private Set<TestPoint> mapDtoPointsToEntity(Set<TestPointDto> pointDtos) {
        Set<TestPoint> testPoints = new TreeSet<TestPoint>();
        for (TestPointDto pointDto : pointDtos) {
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
