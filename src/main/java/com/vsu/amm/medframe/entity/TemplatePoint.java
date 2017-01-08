package com.vsu.amm.medframe.entity;

import javax.persistence.*;

@Entity
@Table(name = "MED_TEMPLATE_POINTS")
public class TemplatePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEMPLATE_POINT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TEMPLATE_ID")
    private Template template;

    @Column(name = "INTENSITY_VALUE")
    private Integer intensityValue;

    @Column(name = "FREQUENCY")
    private Integer frequency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public Template getTemplate() {
        return this.template;
    }

    public Integer getInrensityValue() {
        return intensityValue;
    }

    public void setInrensityValue(Integer intensityValue) {
        this.intensityValue = intensityValue;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "TemplatePoint{" +
                "id=" + id +
                ", template=" + template.toString() +
                ", intensityValue=" + intensityValue +
                ", frequency=" + frequency +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemplatePoint that = (TemplatePoint) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (template != null ? !template.equals(that.template) : that.template != null) return false;
        if (intensityValue != null ? !intensityValue.equals(that.intensityValue) : that.intensityValue != null)
            return false;
        return frequency != null ? frequency.equals(that.frequency) : that.frequency == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (template != null ? template.hashCode() : 0);
        result = 31 * result + (intensityValue != null ? intensityValue.hashCode() : 0);
        result = 31 * result + (frequency != null ? frequency.hashCode() : 0);
        return result;
    }
}
