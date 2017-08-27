package com.vsu.amm.audiometry.controller;

import com.vsu.amm.audiometry.model.entity.User;
import com.vsu.amm.audiometry.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(value = "/add", method = POST)
    public String create(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "", method = GET)
    public String getAll(ModelMap modelMap){
        modelMap.addAttribute("users", userService.getAll());
        return "user/userList";
    }

    @RequestMapping(value = "user", method = GET)
    public String test(ModelMap modelMap){
        modelMap.addAttribute("user", userService.getOne(1L));
        return "user/user";
    }

}
