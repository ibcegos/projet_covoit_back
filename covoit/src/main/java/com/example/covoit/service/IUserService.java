package com.example.covoit.service;

import com.example.covoit.dto.CreateUserDto;
import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.UserEntity;

import java.util.List;


public interface IUserService {

    UserDto toDto (UserEntity entity);

    Integer createUser (CreateUserDto dto);

    List<UserDto> getAllUser();
}
