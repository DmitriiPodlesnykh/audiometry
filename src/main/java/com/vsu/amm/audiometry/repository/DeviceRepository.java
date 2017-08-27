package com.vsu.amm.audiometry.repository;

import com.vsu.amm.audiometry.model.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Query("SELECT device FROM Device device JOIN FETCH device.devicePoints where device.id = (:id)")
    Device findDeviceWithPointsByIdQuery(@Param("id") Long id);
}
