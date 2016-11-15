package com.vsu.amm.medframe.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;


@SpringBootApplication
public class Application {

    public static void main(String[] args){
        ApplicationContext context = SpringApplication.run(MainConfiguration.class);
        System.out.print("main");
    }

}
