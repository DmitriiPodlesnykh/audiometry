package com.vsu.amm.medframe.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dmpo0416 on 11/15/2016.
 */
@RestController
public class MainController {
    @RequestMapping("/")
    public String test(){
        return "string test";
    }
}
