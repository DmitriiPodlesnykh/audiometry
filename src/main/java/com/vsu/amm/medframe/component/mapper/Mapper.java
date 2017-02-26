package com.vsu.amm.medframe.component.mapper;

public interface Mapper<Entity, ModelDto> {
    Entity mapToEntity(ModelDto modelDto);
    ModelDto mapToDto(Entity entity);

}
