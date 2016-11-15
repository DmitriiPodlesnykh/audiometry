package com.vsu.amm.medframe.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    @RequestMapping("/")
    public String test(){
        return "string test";
    }
}
