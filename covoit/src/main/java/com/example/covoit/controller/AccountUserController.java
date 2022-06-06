package com.example.covoit.controller;


import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.RoleEntity;
import com.example.covoit.entity.UserEntity;
import com.example.covoit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Covoit/user/")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountUserController {

    @Autowired
    private AccountService service;

    @PostMapping("add_user")
    public UserEntity addUser(@RequestBody UserDto user) {
        return service.addNewUser(user);
    }

    @PostMapping("roles")
    public RoleEntity addRole(@RequestBody RoleEntity role) {
        return service.addNewRole(role);
    }

    @PostMapping("addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUserForm form) {
        service.addRoleToUser(form.getUsername(), form.getRoleName());
    }


}

class RoleUserForm{
    private String username;
    private String roleName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
