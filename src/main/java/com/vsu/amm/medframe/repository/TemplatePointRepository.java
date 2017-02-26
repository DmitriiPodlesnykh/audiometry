package com.vsu.amm.medframe.repository;

import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.entity.TemplatePoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TemplatePointRepository extends JpaRepository<TemplatePoint, Long>{

    Collection<TemplatePoint> findByTemplate(Template template);

    Collection<TemplatePoint> findByTemplateId(Long templateId);


}
