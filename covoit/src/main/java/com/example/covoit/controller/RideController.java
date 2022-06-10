package com.example.covoit.controller;


import com.example.covoit.dto.RideDto;
import com.example.covoit.dto.SimpleRideDto;
import com.example.covoit.dto.UserDto;
import com.example.covoit.service.IRideService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("Covoit")
public class RideController {
    @Autowired
    private IRideService service;


    @GetMapping("getRides")
    public List<RideDto> getRides() {
        return service.getRides();
    }

    @PostMapping("addRide")
    public ResponseEntity addRide(@RequestBody RideDto dto) {
        System.out.println(dto);
        Integer id = service.createRide(dto);

        if (id == null) {
            return new ResponseEntity("Le trajet n'a pas été créé !", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(id, HttpStatus.CREATED);
    }

//    @GetMapping("get_user_ride")
//    public List<RideDto> getUserRide() {
//        return service.getRidesByUser();
//
//    }
    @GetMapping("getRidesByDeparture/{departure}")
    public List<RideDto> getRidesByDeparture(@PathVariable String departure) {
        return service.getRidesByDeparture(departure);
    }


}
