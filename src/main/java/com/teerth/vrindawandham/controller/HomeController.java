package com.teerth.vrindawandham.controller;


import org.springframework.http.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to Mero Vrindawan !");
    }

}
