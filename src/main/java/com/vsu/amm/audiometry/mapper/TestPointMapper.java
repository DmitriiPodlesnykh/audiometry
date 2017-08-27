package com.vsu.amm.audiometry.mapper;

import com.vsu.amm.audiometry.model.dto.TestPointResponse;
import com.vsu.amm.audiometry.model.entity.TestPoint;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TestPointMapper {

    TestPointMapper INSTANCE = Mappers.getMapper(TestPointMapper.class);

    TestPoint toEntity(TestPointResponse dto);

    TestPointResponse toTestPointResponse(TestPoint entity);

}
