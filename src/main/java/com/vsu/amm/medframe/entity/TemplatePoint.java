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

    public void setTemplate(Template template){
        this.template = template;
    }

    public Template getTemplate(){
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
}
