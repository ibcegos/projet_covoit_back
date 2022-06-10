package com.example.covoit.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.ContactEntity;
import com.example.covoit.service.AccountService;
import com.example.covoit.entity.RoleEntity;
import com.example.covoit.entity.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Covoit/admin/")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountAdminController {

    @Autowired
    private AccountService service;

//    @GetMapping("get_users")
//    public List<UserDto> users() {
//        return service.getAllUsers();
//    }

    @GetMapping("/get_all_users")
    public List<UserDto> getAllUser() {
        return service.getAllUsers();
    }

    @PostMapping("validate_account")
    public UserDto validateAccount(@RequestBody UserDto dto) {
        return service.validateAccountService(dto);
    }

    @DeleteMapping("delete_user/{id}")
    public UserDto deleteUser(@PathVariable String id ) {
        Integer ID = Integer.parseInt(id);
        return service.deleteUserService(ID);
    }

    @GetMapping("/get_users_to_validate")
    public List<UserDto> getUserToValidate() { return service.getUserToValidate(); }

    @PutMapping("update_user")
    public UserDto updateUser(@RequestBody UserDto dto) { return service.updateUserService(dto); }

    @GetMapping("/get_all_contact")
    public List<ContactEntity> getAllContact() {
        return service.getAllContact();
    }

    @GetMapping("refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationToken = request.getHeader("Authorization");
        if (authorizationToken != null && authorizationToken.startsWith("Bearer ")) {
            try {
                String refreshToken = authorizationToken.substring(7);
                Algorithm algorithm = Algorithm.HMAC256("rocBot");
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(refreshToken);
                String username = decodedJWT.getSubject();
                UserEntity user = service.loadUserByUsername(username);
                String jwtAccessToken = JWT.create()
                        .withIssuer(request.getRequestURI().toString())
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 20 * 60 * 1000))
                        .withClaim("roles", user.getRoles().stream().map(RoleEntity::getRoleName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> Tokens = new HashMap<>();
                Tokens.put("accessToken", jwtAccessToken);
                Tokens.put("refreshToken", refreshToken);
                new ObjectMapper().writeValue(response.getOutputStream(), Tokens);
            } catch (Exception e) {

                response.setHeader("error", e.getMessage());
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                Map<String, String> error = new HashMap<>();
                error.put("error", e.getMessage());
                response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);

            }

        } else {
            throw new RuntimeException("Invalid Refresh token");
        }
    }

}
