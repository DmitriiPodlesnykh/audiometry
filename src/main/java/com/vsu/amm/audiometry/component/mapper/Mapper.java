package com.vsu.amm.audiometry.component.mapper;

public interface Mapper<Entity, ModelDto> {
    Entity mapToEntity(ModelDto modelDto);
    ModelDto mapToDto(Entity entity);

}
