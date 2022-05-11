package com.example.covoit.controller;


import com.example.covoit.dto.RideDto;
import com.example.covoit.service.IRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("Covoit")


public class RideController {
    @Autowired
    private IRideService service;


    @GetMapping("getRides")
    public List<RideDto> getRides() {
        return service.getRides();
    }



}
