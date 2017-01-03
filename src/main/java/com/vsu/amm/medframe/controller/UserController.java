package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.entity.User;
import com.vsu.amm.medframe.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(value = "/add", method = POST)
    public String create(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "", method = GET)
    public String getAll(ModelMap modelMap) throws Exception{
        return "user/userList";
    }
}
