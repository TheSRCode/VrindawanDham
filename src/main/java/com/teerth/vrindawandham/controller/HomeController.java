package com.teerth.vrindawandham.controller;


import com.teerth.vrindawandham.entity.User;
import com.teerth.vrindawandham.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping("/home")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to Mero Vrindawan !");
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try{
            System.out.println("HariBol");
            userService.registerUser(user.getUsername(),user.getPassword(),user.getRoles());
            return ResponseEntity.ok("User added successfully!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
