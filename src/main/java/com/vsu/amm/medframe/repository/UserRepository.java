package com.vsu.amm.medframe.repository;


import com.vsu.amm.medframe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
