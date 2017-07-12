package com.vsu.amm.medframe.model.dto;

public class TemplatePointDto extends AbstractPointDto implements Comparable<TemplatePointDto> {

    private Long templateId;

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    @Override
    public String toString() {
        return "TemplatePointDto{" +
                "id=" + id +
                ", intensityValue=" + intensityLevel +
                ", frequency=" + frequency +
                ", templateId=" + templateId +
                '}';
    }

    @Override
    public int compareTo(TemplatePointDto o) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if (this.getFrequency() > o.getFrequency()) {
            return AFTER;
        }
        if (this.getFrequency() < o.getFrequency()) {
            return BEFORE;
        }

        if (this.getFrequency() == o.getFrequency() && super.intensityLevel > o.getIntensityLevel()) {
            return AFTER;
        }
        if (this.getFrequency() == o.getFrequency() && super.intensityLevel < o.getIntensityLevel()) {
            return BEFORE;
        }

        return EQUAL;
    }

}
