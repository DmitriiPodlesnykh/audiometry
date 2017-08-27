package com.vsu.amm.audiometry.repository;

import com.vsu.amm.audiometry.model.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestRepository extends JpaRepository<Test, Long>{
}
