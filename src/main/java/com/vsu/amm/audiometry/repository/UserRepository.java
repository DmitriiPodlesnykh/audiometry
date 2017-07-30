package com.vsu.amm.audiometry.repository;


import com.vsu.amm.audiometry.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);
}
