package com.vsu.amm.medframe.dto;

public class TemplatePointDto extends AbstractPointDto implements Comparable<TemplatePointDto> {

    private Long templateId;

    public Long getTemplateId() {
        return templateId;
    }



    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    /*public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Integer getIntensityValue() {
        return intensityValue;
    }

    public void setIntensityValue(Integer intensityValue) {
        this.intensityValue = intensityValue;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
*/
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

        if (this.getFrequency()==o.getFrequency() && super.intensityLevel > o.getIntensityLevel()) {
            return AFTER;
        }
        if (this.getFrequency() == o.getFrequency() && super.intensityLevel < o.getIntensityLevel()) {
            return BEFORE;
        }

        return EQUAL;
    }

}
