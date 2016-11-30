package com.vsu.amm.medframe.repository;

import com.vsu.amm.medframe.entity.Simple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleRepository extends JpaRepository<Simple, Long> {

    Simple findById(Long id);
}
