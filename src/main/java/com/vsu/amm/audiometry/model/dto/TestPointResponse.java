package com.vsu.amm.audiometry.model.dto;

public class TestPointResponse extends AbstractPointElement{

    private Long id;

    private Long testId;

    private String status;

    public Long getTestId() {
        return testId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(o instanceof TestPointResponse)) return false;

        TestPointResponse that = (TestPointResponse) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getTestId() != null ? !getTestId().equals(that.getTestId()) : that.getTestId() != null) return false;
        return getStatus() != null ? getStatus().equals(that.getStatus()) : that.getStatus() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTestId() != null ? getTestId().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestPointResponse{" +
                "frequency=" + frequency +
                ", id=" + id +
                ", intensityLevel=" + intensityLevel +
                ", testId=" + testId +
                ", status='" + status + '\'' +
                '}';
    }
}
