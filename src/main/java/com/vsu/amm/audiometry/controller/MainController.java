package com.vsu.amm.audiometry.controller;

import com.vsu.amm.audiometry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String test(){
        return "string test";
    }

    @RequestMapping("/test")
    public Object testUser(){
        if(userRepository.findById(1L) != null){
            System.out.println("userRepository.findByFirstName != null");
            return userRepository.findById(1L);
        }else {
            System.out.println("userRepository.findByFirstName = null");
            return "result null";
        }
    }

}
