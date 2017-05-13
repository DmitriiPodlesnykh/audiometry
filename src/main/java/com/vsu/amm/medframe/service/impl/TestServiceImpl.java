package com.vsu.amm.medframe.service.impl;

import com.vsu.amm.medframe.component.mapper.impl.TestMapper;
import com.vsu.amm.medframe.component.mapper.impl.TestPointMapper;
import com.vsu.amm.medframe.dto.PatientDto;
import com.vsu.amm.medframe.dto.TestDto;
import com.vsu.amm.medframe.dto.TestPointDto;
import com.vsu.amm.medframe.entity.Test;
import com.vsu.amm.medframe.repository.TestPointRepository;
import com.vsu.amm.medframe.repository.TestRepository;
import com.vsu.amm.medframe.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestPointRepository testPointRepository;

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private TestPointMapper testPointMapper;

    @Override
    public TestDto save(TestDto testDto) {
        Test test = testMapper.mapToEntity(testDto);
        test = testRepository.save(test);
        return testMapper.mapToDto(test);
    }

    @Override
    public TestDto getTestById(Long id) {
        return null;
    }

    @Override
    public void deleteTest(Long id) {

    }

    @Override
    public List<TestDto> getAllPatientsTests(PatientDto patient) {
        return null;
    }

    @Override
    public List<TestDto> getAll() {
        return null;
    }

    @Override
    public TestPointDto save(TestPointDto testPointDto) {
        return null;
    }

    @Override
    public TestPointDto getTestPointById(Long id) {
        return null;
    }

    @Override
    public void deletePoint(Long id) {

    }
}
