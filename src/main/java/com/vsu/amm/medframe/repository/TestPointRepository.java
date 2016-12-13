package com.vsu.amm.medframe.repository;


import com.vsu.amm.medframe.entity.TestPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestPointRepository extends JpaRepository<TestPoint, Long> {
}
