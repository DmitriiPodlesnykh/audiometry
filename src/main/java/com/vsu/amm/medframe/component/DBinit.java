package com.vsu.amm.medframe.component;

import com.vsu.amm.medframe.entity.User;
import com.vsu.amm.medframe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class DBinit {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public DBinit(UserRepository userRepository, UserRepository userRepository1) {
        this.userRepository = userRepository1;
    }

    @PostConstruct
    @Transactional
    public void init() {
        System.out.println("DBinit init() start");

        //checkTables();
        addUserForTest();
    }

    private void checkTables(){
        System.out.println("All tables checked");
    }

    private void addUserForTest(){
        User user = new User();
        user.setFirstName("Pop");
        user.setLastName("qwerty");
        user.setUserType("Admin");
        user.setEmail("11@qw.ru");
        user.setPassword("sde");
        user.setMiddleName("qwqqq");

        userRepository.save(user);

        System.out.println("User added");
    }

}
