package com.teerth.vrindawandham.controller;

import com.teerth.vrindawandham.entity.Temple;
import com.teerth.vrindawandham.service.TempleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temple")
public class TempleController {

    @Autowired
    TempleService templeService;

    @GetMapping("/all")
    public ResponseEntity<List<Temple>> getTemple(){

        return templeService.getTemples();
    }

    @PostMapping("/add")
    public ResponseEntity<Temple> addTemple(@RequestBody Temple temple){

            return templeService.addTemple(temple);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Temple> getTemple(@PathVariable int id){
        return templeService.getTempleById(id);
    }

}
