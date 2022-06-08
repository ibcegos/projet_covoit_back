package com.example.covoit.controller;

import com.example.covoit.dto.UserDto;
import com.example.covoit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Covoit/admin/")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountAdminController {

    @Autowired
    private AccountService service;

    @GetMapping("get_users")
    public List<UserDto> users() {
        return service.listUsers();
    }

    @PostMapping("validate_account")
    public UserDto validateAccount(@RequestBody UserDto dto) {

        return service.validateAccountService(dto);
    }


}
