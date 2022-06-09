package com.example.covoit.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.RoleEntity;
import com.example.covoit.entity.UserEntity;
import com.example.covoit.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Covoit")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountUserController {

    @Autowired
    private AccountService service;

    @PostMapping("/user/add_user")
    public UserEntity addUser(@RequestBody UserDto user) {
        return service.addNewUser(user);
    }

    @PostMapping("/user/roles")
    public RoleEntity addRole(@RequestBody RoleEntity role) {
        return service.addNewRole(role);
    }

    @PostMapping("/user/addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUserForm form) {
        service.addRoleToUser(form.getUsername(), form.getRoleName());
    }



    class RoleUserForm {
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
}

