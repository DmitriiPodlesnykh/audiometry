package com.vsu.amm.medframe.dto;


import com.vsu.amm.medframe.entity.TemplatePoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TemplateDto {

    private Long id;

    private String name;

    private String description;

    private Long authorId;

    private List<TemplatePointDto> points = new ArrayList<TemplatePointDto>();

    public List<TemplatePointDto> getPoints() {
        return points;
    }

    public void setPoints(List<TemplatePointDto> points) {
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "TemplateDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", authorId=" + authorId +
                ", points=" + points.toString() +
                '}';
    }
}
