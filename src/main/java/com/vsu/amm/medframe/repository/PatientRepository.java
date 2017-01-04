package com.vsu.amm.medframe.repository;

import com.vsu.amm.medframe.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDoctorId(Long doctorId);
}
