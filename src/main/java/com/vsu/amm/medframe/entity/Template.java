package com.vsu.amm.medframe.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "MED_TEMPLATES")
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEMPLATE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private User author;

    @OneToMany()
    @JoinColumn(name = "TEMPLATE_ID")
    private Set<TemplatePoint> templatePoints;

    public void setTemplatePoints(Set<TemplatePoint> templatePoints){
        this.templatePoints = templatePoints;
    }

    public Set<TemplatePoint> getTemplatePoints(){
        return this.templatePoints;
    }


    public User getAuthor(){
        return author;
    }

    public void setAuthor(User user){
        this.author = user;
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

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
