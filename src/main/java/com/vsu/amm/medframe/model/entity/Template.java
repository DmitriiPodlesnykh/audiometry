package com.vsu.amm.medframe.model.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "MED_TEMPLATES")
public class Template {
    @Id
    //@Column(name = "TEMPLATE_ID", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEMPLATE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    private User author;

    @OneToMany(mappedBy = "template")
    private Set<TemplatePoint> templatePoints = new TreeSet<TemplatePoint>();

    public Set<TemplatePoint> getTemplatePoints() {
        return templatePoints;
    }

    public void setTemplatePoints(Set<TemplatePoint> templatePoints) {
        this.templatePoints = templatePoints;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User user) {
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
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", author=" + (author != null ? author.toString() : "is empty") +
                ", templatePoints=" + templatePoints.toString() +
                //", tests=" + tests.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Template template = (Template) o;

        if (id != null ? !id.equals(template.id) : template.id != null) return false;
        if (name != null ? !name.equals(template.name) : template.name != null) return false;
        if (description != null ? !description.equals(template.description) : template.description != null)
            return false;
        if (author != null ? !author.equals(template.author) : template.author != null) return false;
        //if (templatePoints != null ? !templatePoints.equals(template.templatePoints) : template.templatePoints != null)
        //   return false;
        //return tests != null ? tests.equals(template.tests) : template.tests == null;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        // result = 31 * result + (templatePoints != null ? templatePoints.hashCode() : 0);
        // result = 31 * result + (tests != null ? tests.hashCode() : 0);
        return result;
    }
}
