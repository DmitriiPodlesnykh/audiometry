package com.vsu.amm.audiometry.mapper;

import com.vsu.amm.audiometry.model.dto.CreateTestRequest;
import com.vsu.amm.audiometry.model.dto.TestResponse;
import com.vsu.amm.audiometry.model.entity.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//@Mapper
public interface TestMapper {

    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);

    Test mapToEntity(CreateTestRequest dto);

    Test mapToEntity(TestResponse dto);

    CreateTestRequest mapToCreateTestRequest(Test entity);

    TestResponse mapToTestResponse(Test entity);
}
