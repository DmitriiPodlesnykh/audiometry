package com.vsu.amm.medframe.repository;

import com.vsu.amm.medframe.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
