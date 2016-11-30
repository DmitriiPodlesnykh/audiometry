package com.vsu.amm.medframe.repository;


import com.vsu.amm.medframe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    /*@Query("SELECT users from med_users users where users.user_id=1")
    User findT();*/
}
