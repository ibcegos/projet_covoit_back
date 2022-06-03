package com.example.covoit.service;

import com.example.covoit.dto.RoleDto;
import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.ERole;
import com.example.covoit.entity.RoleEntity;
import com.example.covoit.entity.UserEntity;

import java.util.List;

public interface IRoleService {

    RoleDto toDtoRole (RoleEntity entity);

    UserDto toDtoUser(UserEntity entity);

//    RoleEntity toEntity (RoleDto dto);

    void createRoleToUser(String username, ERole name);



    List<RoleDto> getAllRoles ();



    RoleDto updateRole (RoleDto dto);

    RoleDto getRoleById (Long id);


}






