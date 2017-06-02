package com.vsu.amm.medframe.model.dto;

public class TestPointDto extends AbstractPointDto{

    private Long testId;

    private String status;

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestPointDto)) return false;

        TestPointDto that = (TestPointDto) o;

        if (!getTestId().equals(that.getTestId())) return false;
        return getStatus().equals(that.getStatus());
    }

    @Override
    public int hashCode() {
        int result = getTestId().hashCode();
        result = 31 * result + getStatus().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TestPointDto{" +
                "id=" + (id != null ? id : "is empty") +
                ", frequency=" + frequency +
                ", test=" + (testId != null ? testId : "is empty" ) +
                ", intensityLevel=" + intensityLevel +
                ", status='" + status + '\'' +
                '}';
    }
}
