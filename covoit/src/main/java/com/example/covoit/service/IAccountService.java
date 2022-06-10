package com.example.covoit.service;

import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.ContactEntity;
import com.example.covoit.entity.RoleEntity;
import com.example.covoit.entity.UserEntity;

import java.util.List;

public interface IAccountService {

    RoleEntity addNewRole(RoleEntity role);

    UserEntity addNewUser(UserDto user);

    void addRoleToUser(String username, String  roleName);

    UserEntity loadUserByUsername(String username);

    List<UserDto> getAllUsers();

    UserDto toDto (UserEntity entity);

    UserEntity toEntity(UserDto dto);

    UserDto validateAccountService(UserDto dto);

    UserDto deleteUserService(Integer id);

    List<UserDto> getUserToValidate();

    UserDto updateUserService(UserDto dto);

    String getUserByUsername(String username);

    void sendMessage(ContactEntity contact);

    List<ContactEntity> getAllContact();

}
