package com.vsu.amm.medframe.component.mapper.impl;


import com.vsu.amm.medframe.component.mapper.Mapper;
import com.vsu.amm.medframe.model.dto.TestDto;
import com.vsu.amm.medframe.model.dto.TestPointDto;
import com.vsu.amm.medframe.model.entity.Test;
import com.vsu.amm.medframe.model.entity.TestPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TestMapper implements Mapper<Test, TestDto> {

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    private TestPointMapper testPointMapper;


    @Override
    public Test mapToEntity(TestDto testDto) {
        Test test = new Test();
        if (testDto.getId() != null) {
            test.setId(testDto.getId());
        }
        test.setDate(testDto.getDate());
        if (testDto.getPatient() != null) {
            test.setPatient(patientMapper.mapToEntity(testDto.getPatient()));
        }
        if (testDto.getTemplate() != null) {
            test.setTemplate(templateMapper.mapToEntity(testDto.getTemplate()));
        }
        if (testDto.getPoints() != null && !testDto.getPoints().isEmpty()) {
            Set<TestPoint> testPoints = new HashSet<TestPoint>();
            for (TestPointDto pointDto : testDto.getPoints()) {
                TestPoint testPoint = testPointMapper.mapToEntity(pointDto);
                testPoints.add(testPoint);
            }
            test.setTestPoints(testPoints);
        }
        return test;
    }

    @Override
    public TestDto mapToDto(Test test) {
        TestDto testDto = new TestDto();
        if (test.getId() != null) {
            testDto.setId(test.getId());
        }
        if (test.getPatient() != null) {
            testDto.setPatient(patientMapper.mapToDto(test.getPatient()));
        }
        if (test.getTemplate() != null) {
            testDto.setTemplate(templateMapper.mapToDto(test.getTemplate()));
        }
        testDto.setDate(test.getDate());
        if (test.getTestPoints() != null && !test.getTestPoints().isEmpty()) {
            Set<TestPointDto> pointDtos = new HashSet<TestPointDto>();
            for (TestPoint point : test.getTestPoints()) {
                TestPointDto pointDto = testPointMapper.mapToDto(point);
                pointDtos.add(pointDto);
            }
            testDto.setPoints(pointDtos);
        }
        return testDto;
    }

    public List<TestDto> mapToDto(List<Test> tests) {
        List<TestDto> testDtos = new ArrayList<TestDto>();
        for(Test test : tests) {
            TestDto testDto = mapToDto(test);
            testDtos.add(testDto);
        }
        return testDtos;
    }
}
