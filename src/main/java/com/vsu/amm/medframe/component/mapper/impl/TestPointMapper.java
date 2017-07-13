package com.vsu.amm.medframe.component.mapper.impl;

import com.vsu.amm.medframe.component.mapper.Mapper;
import com.vsu.amm.medframe.model.dto.TestPointResponse;
import com.vsu.amm.medframe.model.entity.TestPoint;
import com.vsu.amm.medframe.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestPointMapper implements Mapper<TestPoint, TestPointResponse> {

    @Autowired
    private TestRepository testRepository;

    @Override
    public TestPoint mapToEntity(TestPointResponse testPointResponse) {
        TestPoint point = new TestPoint();
        //TODO fix it
        //point.setFrequency(testPointResponse.getFrequency());
        //point.setIntensityValue(testPointResponse.getIntensityLevel());
        //point.setStatus(testPointResponse.getStatus());
        if (testPointResponse.getTestId() != null) {
            point.setTest(testRepository.getOne(testPointResponse.getTestId()));
        }
        if (testPointResponse.getId() != null) {
            point.setId(testPointResponse.getId());
        }
        return point;
    }

    @Override
    public TestPointResponse mapToDto(TestPoint testPoint) {
        TestPointResponse pointDto = new TestPointResponse();
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
