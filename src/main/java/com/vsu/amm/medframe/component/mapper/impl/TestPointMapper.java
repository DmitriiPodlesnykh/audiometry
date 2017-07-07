package com.vsu.amm.medframe.component.mapper.impl;

import com.vsu.amm.medframe.component.mapper.Mapper;
import com.vsu.amm.medframe.model.dto.TestPointDto;
import com.vsu.amm.medframe.model.entity.TestPoint;
import com.vsu.amm.medframe.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestPointMapper implements Mapper<TestPoint, TestPointDto> {

    @Autowired
    private TestRepository testRepository;

    @Override
    public TestPoint mapToEntity(TestPointDto testPointDto) {
        TestPoint point = new TestPoint();
        //TODO fix it
        //point.setFrequency(testPointDto.getFrequency());
        //point.setIntensityValue(testPointDto.getIntensityLevel());
        //point.setStatus(testPointDto.getStatus());
        if (testPointDto.getTestId() != null) {
            point.setTest(testRepository.getOne(testPointDto.getTestId()));
        }
        if (testPointDto.getId() != null) {
            point.setId(testPointDto.getId());
        }
        return point;
    }

    @Override
    public TestPointDto mapToDto(TestPoint testPoint) {
        TestPointDto pointDto = new TestPointDto();
        //TODO fix it
        //pointDto.setStatus(testPoint.getStatus());
        if (testPoint.getId() != null) {
            pointDto.setId(testPoint.getId());
        }
        if (testPoint.getTest() != null) {
            pointDto.setTestId(testPoint.getTest().getId());
        }
        //TODO fix it
        //pointDto.setIntensityLevel(testPoint.getIntensityValue());
        //pointDto.setFrequency(testPoint.getFrequency());
        return pointDto;
    }
}
