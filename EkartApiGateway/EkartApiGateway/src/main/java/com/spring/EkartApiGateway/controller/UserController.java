package com.spring.EkartApiGateway.controller;

import com.spring.EkartApiGateway.entity.User;
import com.spring.EkartApiGateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        System.out.println("Hello this is register method");
        System.out.println("Hello register");
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        System.out.println("Hello this is login method");
        System.out.println("Hello login");
        System.out.println("Hello controller");
        return service.verify(user);
    }
}
