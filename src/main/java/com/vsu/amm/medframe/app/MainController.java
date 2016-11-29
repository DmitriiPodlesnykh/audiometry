package com.vsu.amm.medframe.app;

import com.vsu.amm.medframe.repository.UserRepository;
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

    @RequestMapping("/q")
    public String test1(){
        return "test1";
    }

    @RequestMapping("/t")
    public Object testUser(){
        System.out.println("in testUser");
        if(userRepository.findByFirstName("Ivan") != null){
            System.out.println("userRepository.findByFirstName != null");
            return userRepository.findByFirstName("Ivan");
        }else {
            System.out.println("userRepository.findByFirstName = null");
            return "result null";
        }
    };
}
