package com.vsu.amm.audiometry.component.mapper.impl;


import com.vsu.amm.audiometry.component.mapper.Mapper;
import com.vsu.amm.audiometry.model.dto.TestPointResponse;
import com.vsu.amm.audiometry.model.dto.TestResponse;
import com.vsu.amm.audiometry.model.entity.Test;
import com.vsu.amm.audiometry.model.entity.TestPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TestMapper implements Mapper<Test, TestResponse> {

    private final PatientMapper patientMapper;
    private final TemplateMapper templateMapper;
    private final TestPointMapper testPointMapper;

    @Override
    public Test mapToEntity(TestResponse testResponse) {
        Test test = new Test();
        if (testResponse.getId() != null) {
            test.setId(testResponse.getId());
        }
        test.setDate(testResponse.getDate());
        if (testResponse.getPatient() != null) {
            test.setPatient(patientMapper.mapToEntity(testResponse.getPatient()));
        }
        if (testResponse.getTemplate() != null) {
            test.setTemplate(templateMapper.mapToEntity(testResponse.getTemplate()));
        }
        if (testResponse.getPoints() != null && !testResponse.getPoints().isEmpty()) {
            Set<TestPoint> testPoints = new HashSet<TestPoint>();
            for (TestPointResponse pointDto : testResponse.getPoints()) {
                TestPoint testPoint = testPointMapper.mapToEntity(pointDto);
                testPoints.add(testPoint);
            }
            test.setTestPoints(testPoints);
        }
        return test;
    }

    @Override
    public TestResponse mapToDto(Test test) {
        TestResponse testResponse = new TestResponse();
        if (test.getId() != null) {
            testResponse.setId(test.getId());
        }
        if (test.getPatient() != null) {
            testResponse.setPatient(patientMapper.mapToDto(test.getPatient()));
        }
        if (test.getTemplate() != null) {
            testResponse.setTemplate(templateMapper.mapToDto(test.getTemplate()));
        }
        testResponse.setDate(test.getDate());
        if (test.getTestPoints() != null && !test.getTestPoints().isEmpty()) {
            Set<TestPointResponse> pointDtos = new HashSet<TestPointResponse>();
            for (TestPoint point : test.getTestPoints()) {
                TestPointResponse pointDto = testPointMapper.mapToDto(point);
                pointDtos.add(pointDto);
            }
            testResponse.setPoints(pointDtos);
        }
        return testResponse;
    }

    public List<TestResponse> mapToDto(List<Test> tests) {
        List<TestResponse> testResponses = new ArrayList<TestResponse>();
        for(Test test : tests) {
            TestResponse testResponse = mapToDto(test);
            testResponses.add(testResponse);
        }
        return testResponses;
    }

    @Autowired
    public TestMapper(PatientMapper patientMapper, TemplateMapper templateMapper, TestPointMapper testPointMapper) {
        this.patientMapper = patientMapper;
        this.templateMapper = templateMapper;
        this.testPointMapper = testPointMapper;
    }
}
