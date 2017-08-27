package com.vsu.amm.audiometry.repository;


import com.vsu.amm.audiometry.model.entity.TestPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestPointRepository extends JpaRepository<TestPoint, Long> {
}
