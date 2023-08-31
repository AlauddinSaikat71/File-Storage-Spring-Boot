package com.luv2code.springboot.demo.mycoolapp.controller;

import com.luv2code.springboot.demo.mycoolapp.entity.UserEntity;
import com.luv2code.springboot.demo.mycoolapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping()
    public List<UserEntity> getAll(){
        return this.userService.getAll();
    }

}
