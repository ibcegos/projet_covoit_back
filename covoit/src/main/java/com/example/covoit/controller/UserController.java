package com.example.covoit.controller;

import com.example.covoit.dto.RideDto;
import com.example.covoit.dto.UserDto;
import com.example.covoit.service.IUserService;
import com.example.covoit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("Covoit")
public class UserController {

    @Autowired
    private UserService service;

//    @PostMapping("add_user")
//    public ResponseEntity addUser(@RequestBody UserDto dto) {
//
//        Integer id = service.createUser(dto);
//
//        if (id == null) {
//            return new ResponseEntity("L'utilisateur n'a pas été crée !", HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity(id, HttpStatus.CREATED);
//    }


    @GetMapping("getUserProfil/{username}")
    public UserDto getProfil(@PathVariable String username) {

        return service.getUserProfil(username);
    }


}
