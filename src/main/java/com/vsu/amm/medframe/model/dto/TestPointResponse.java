package com.vsu.amm.medframe.model.dto;

public class TestPointResponse {

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
        return "TestPointResponse{" +
                "id=" + (id != null ? id : "is empty") +
                ", test=" + (testId != null ? testId : "is empty") +
                ", status='" + status + '\'' +
                '}';
    }
}