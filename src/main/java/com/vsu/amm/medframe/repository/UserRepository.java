package com.vsu.amm.medframe.repository;


import com.vsu.amm.medframe.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);
}
