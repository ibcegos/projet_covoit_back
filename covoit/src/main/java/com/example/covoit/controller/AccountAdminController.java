package com.example.covoit.controller;

import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.ContactEntity;
import com.example.covoit.service.AccountService;
import com.example.covoit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
