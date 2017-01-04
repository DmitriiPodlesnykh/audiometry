package com.vsu.amm.medframe.repository;

import com.vsu.amm.medframe.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long>{
}
