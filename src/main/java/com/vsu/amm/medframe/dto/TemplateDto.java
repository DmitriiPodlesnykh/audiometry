package com.vsu.amm.medframe.dto;


import java.util.Set;

public class TemplateDto {

    private Long id;

    private String name;

    private String description;

    private Long authorId;

    private Set<TemplatePointDto> points;

    public void setPoints(Set<TemplatePointDto> points){
        this.points = points;
    }

    public Set<TemplatePointDto> getPoints(){
        return points;
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
}
