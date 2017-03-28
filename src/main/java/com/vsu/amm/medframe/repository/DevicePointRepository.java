package com.vsu.amm.medframe.repository;

import com.vsu.amm.medframe.entity.Device;
import com.vsu.amm.medframe.entity.DevicePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DevicePointRepository extends JpaRepository<DevicePoint, Long>{

    Collection<DevicePoint> findByDeviceId(Long deviceId);

    Collection<DevicePoint> findByDevice(Device device);
}