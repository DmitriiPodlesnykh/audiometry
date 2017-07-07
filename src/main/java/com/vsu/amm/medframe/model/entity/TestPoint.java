package com.vsu.amm.medframe.model.entity;

import com.vsu.amm.medframe.enums.TestPointStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MED_TEST_POINTS")
public class TestPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POINT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TEST_ID")
    private Test test;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private TestPointStatus pointStatus;

    @ManyToMany
    @JoinTable(name = "MED_TEST_POINTS_DEVICE_POINTS",
            joinColumns = @JoinColumn(name = "TEST_POINT_ID", referencedColumnName = "POINT_ID"),
            inverseJoinColumns = @JoinColumn(name = "DEVICE_POINT_ID", referencedColumnName = "DEVICE_POINT_ID")
    )
    private List<DevicePoint> devicePoints = new ArrayList<DevicePoint>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<DevicePoint> getDevicePoint() {
        return devicePoints;
    }

    public void setDevicePoint(List<DevicePoint> devicePoint) {
        this.devicePoints = devicePoint;
    }

    public TestPointStatus getPointStatus() {
        return pointStatus;
    }

    public void setPointStatus(TestPointStatus pointStatus) {
        this.pointStatus = pointStatus;
    }

    public List<DevicePoint> getDevicePoints() {
        return devicePoints;
    }

    public void setDevicePoints(List<DevicePoint> devicePoints) {
        this.devicePoints = devicePoints;
    }

    @Override
    public String toString() {
        return "TestPoint{" +
                "id=" + id +
                ", test=" + test.toString() +
                ", status='" + pointStatus.name() + '\'' +
                ", devicePoints='" + devicePoints.toString() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestPoint testPoint = (TestPoint) o;

        if (id != null ? !id.equals(testPoint.id) : testPoint.id != null) return false;
        if (test != null ? !test.equals(testPoint.test) : testPoint.test != null) return false;
        return pointStatus != null ? pointStatus.equals(testPoint.pointStatus) : testPoint.pointStatus == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (test != null ? test.getId().hashCode() : 0);
        result = 31 * result + (pointStatus != null ? pointStatus.hashCode() : 0);
        return result;
    }
}


