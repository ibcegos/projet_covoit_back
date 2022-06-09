package com.example.covoit.service;

import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.UserEntity;

import java.util.List;


public interface IUserService {

    UserDto toDto (UserEntity entity);

    UserEntity toEntity(UserDto dto);

    Integer createUser (UserDto dto);

    //pas utilisé
    List<UserDto> getAllUser();

    List<UserDto> getUserToValidate();

    UserDto validateAccountService(UserDto dto);


}
