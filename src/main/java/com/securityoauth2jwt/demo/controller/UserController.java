package com.securityoauth2jwt.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @RequestMapping(value="/home")
    public String home() {
        return "this is user home";
    }
}
