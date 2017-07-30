package com.vsu.amm.audiometry.repository;

import com.vsu.amm.audiometry.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDoctorId(Long doctorId);
}
