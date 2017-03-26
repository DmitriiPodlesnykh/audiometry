package com.vsu.amm.medframe.repository;

import com.vsu.amm.medframe.entity.DevicePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicePointRepository extends JpaRepository<DevicePoint, Long>{
}