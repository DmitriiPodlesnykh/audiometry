package com.vsu.amm.medframe.repository;

import com.vsu.amm.medframe.model.entity.Device;
import com.vsu.amm.medframe.model.entity.DevicePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DevicePointRepository extends JpaRepository<DevicePoint, Long>{

    Collection<DevicePoint> findByDeviceId(Long deviceId);

    Collection<DevicePoint> findByDevice(Device device);

    @Query("SELECT devicePoint FROM DevicePoint devicePoint where devicePoint.id = (:id) and devicePoint.intensityLevel = 0")
    Collection<DevicePoint> getZeroIntensityLevelDevicePointsByDeviceId(@Param("id") Long id);
}