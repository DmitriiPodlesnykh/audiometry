package com.vsu.amm.audiometry.app;

import com.vsu.amm.audiometry.MainConfiguration;
import org.springframework.boot.SpringApplication;

public class Application {

    public static void main(String[] args){
        SpringApplication.run(MainConfiguration.class);
        System.out.print("Application started");
    }

}
