package com.vsu.amm.medframe.model.entity;


import com.vsu.amm.medframe.enums.Frequency;

import javax.persistence.*;

@Entity
@Table(name = "MED_TEMPLATE_FREQUENCIES")
public class TemplateFrequency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEMPLATE_ID")
    private Template template;

    private Frequency value;

    public TemplateFrequency(Long id, Template template, Frequency value) {
        this.id = id;
        this.template = template;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public Frequency getValue() {
        return value;
    }

    public void setValue(Frequency value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TemplateFrequency{" +
                "id=" + id +
                ", template=" + template +
                ", value=" + value.toString() +
                '}';
    }
}
