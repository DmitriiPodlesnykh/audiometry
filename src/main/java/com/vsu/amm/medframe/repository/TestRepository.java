package com.vsu.amm.medframe.repository;

import com.vsu.amm.medframe.model.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestRepository extends JpaRepository<Test, Long>{
}
