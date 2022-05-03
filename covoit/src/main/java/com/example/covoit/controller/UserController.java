package com.example.covoit.controller;

import com.example.covoit.dto.CreateUserDto;
import com.example.covoit.dto.UserDto;
import com.example.covoit.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("Covoit")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("getAllUser")
    public List<UserDto> getAllUser() {
        return service.getAllUser();
    }

    @PostMapping("add_user")
    public ResponseEntity addUser(@RequestBody CreateUserDto dto) {

        Integer id = service.createUser(dto);

        if (id == null) {
            return new ResponseEntity("L'utilisateur n'a pas été crée !", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(id, HttpStatus.CREATED);
    }



}
