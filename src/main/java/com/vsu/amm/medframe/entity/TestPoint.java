package com.vsu.amm.medframe.entity;

import javax.lang.model.element.Name;
import javax.persistence.*;

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

    @Column(name = "FREQUENCY")
    private Integer frequency;

    @Column(name = "INTENSITY_VALUE")
    private int intensityValue;

    @Column(name = "STATUS")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public int getIntensityValue() {
        return intensityValue;
    }

    public void setIntensityValue(int intensityValue) {
        this.intensityValue = intensityValue;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TestPoint{" +
                "id=" + id +
                ", test=" + test.toString() +
                ", frequency=" + frequency +
                ", intensityValue=" + intensityValue +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestPoint testPoint = (TestPoint) o;

        if (id != null ? !id.equals(testPoint.id) : testPoint.id != null) return false;
        if (test != null ? !test.equals(testPoint.test) : testPoint.test != null) return false;
        if (frequency != null ? !frequency.equals(testPoint.frequency) : testPoint.frequency != null) return false;
       // if (intensityValue != null ? !intensityValue.equals(testPoint.intensityValue) : testPoint.intensityValue != null)
         //   return false;
        return status != null ? status.equals(testPoint.status) : testPoint.status == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (test != null ? test.hashCode() : 0);
        result = 31 * result + (frequency != null ? frequency.hashCode() : 0);
        result = 31 * result + intensityValue;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}


