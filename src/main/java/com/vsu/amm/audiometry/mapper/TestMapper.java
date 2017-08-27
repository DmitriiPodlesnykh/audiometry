package com.vsu.amm.audiometry.mapper;

import com.vsu.amm.audiometry.model.dto.CreateTestRequest;
import com.vsu.amm.audiometry.model.dto.TestResponse;
import com.vsu.amm.audiometry.model.entity.Test;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        TestPointMapper.class,
        PatientMapper.class,
        TemplateMapper.class
})
public interface TestMapper {

    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);


    Test mapToEntity(CreateTestRequest dto);

    //@Mapping(source = "patient.id", )
    TestResponse toTestResponse(Test entity);

    @InheritInverseConfiguration
    Test fromTestResponse(TestResponse dto);
}
