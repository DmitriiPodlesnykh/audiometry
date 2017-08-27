package com.vsu.amm.audiometry.mapper;

import com.vsu.amm.audiometry.model.dto.PatientDto;
import com.vsu.amm.audiometry.model.entity.Patient;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientDto toPatientDto(Patient entity);

    @InheritInverseConfiguration
    Patient fromPatientDto(PatientDto dto);
}
