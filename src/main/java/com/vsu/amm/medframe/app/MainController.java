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

    @RequestMapping("/t")
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
