package com.vsu.amm.audiometry.repository;

import com.vsu.amm.audiometry.model.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long>{
  
  @Query("SELECT t FROM Template t JOIN FETCH t.author")
  List<Template> findAllTemplatesWithAuthorQ();
  
  @Query("SELECT t FROM Template t JOIN FETCH t.author WHERE t.id = (:id)")
  Template findTemplateWithAuthorByIdQ(@Param("id") Long id);

  //@Query("SELECT t FROM Template t JOIN FETCH t.author JOIN FETCH t.templatePoints WHERE t.id = (:id)")
  @Query("SELECT t FROM Template t WHERE t.id = (:id)")
  Template findWithTemplatePointsByIdQ(@Param("id") Long id);

  @Query("SELECT t FROM Template t JOIN FETCH t.author")
  List<Template> findTemplatesQ();
}
