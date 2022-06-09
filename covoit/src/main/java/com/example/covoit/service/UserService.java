package com.example.covoit.service;

import com.example.covoit.dto.RoleDto;
import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.DriversEntity;
import com.example.covoit.entity.RoleEntity;
import com.example.covoit.entity.UserEntity;
import com.example.covoit.repository.IUserRepository;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    public IUserRepository repository;

    @Override
    public UserDto toDto(UserEntity entity) {
        UserDto dto = new UserDto();
        RoleDto roleDto = new RoleDto();
        // a for loop to get the roles to set the roleDto
//        for (RoleEntity roleEntity : entity.getRoles()) {
//            roleDto.setId(roleEntity.getId());
//            roleDto.setRoleName(roleEntity.getRoleName());
//        }
        if (dto.getId() != null) {
            roleDto.setRoleName(entity.getRoles().toString());
        }
        dto.setId(entity.getId());

        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setConnect(entity.getConnect());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setAvatar(entity.getAvatar());
//        dto.setRole(roleDto);
        dto.setVerified(entity.getVerified());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    @Override
    public UserEntity toEntity(UserDto dto) {
        RoleEntity userRole = new RoleEntity();
        userRole.setRoleName("User");
        userRole.setId(1);

        UserEntity entity = new UserEntity();

        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setConnect(false);
        entity.setPhoneNumber(dto.getPhoneNumber());
//        entity.setRoles(userRole);
        entity.setPassword(dto.getPassword());
        entity.setAvatar(dto.getAvatar());
        entity.setVerified(false);
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }

    @Override
    public Integer createUser(UserDto dto) {
        UserEntity entity = this.toEntity(dto);
        entity.setCreatedAt(LocalDateTime.now());
        try {
            repository.saveAndFlush(entity);
            return entity.getId();
        } catch(Exception e) {
            return null;
        }
    }

    //pas utilisé !!!
    @Override
    public List<UserDto> getAllUser() {
        List<UserEntity> userList = repository.findAll();
        List<UserDto> listAllUser = new ArrayList<>();

        for (int i =0; i < userList.size(); i++) {
            UserEntity entity = userList.get(i);
            UserDto dto = this.toDto(entity);
            listAllUser.add(dto);
        }
        return listAllUser;
    }

    @Override
    public List<UserDto> getUserToValidate() {
        List<UserEntity> userToValidate = repository.findByUserNoValidate();
        List<UserDto> listAllUserNoValidate = new ArrayList<>();

        for (int i =0; i < userToValidate.size(); i++) {
            UserEntity entity = userToValidate.get(i);
            UserDto dto = this.toDto(entity);
            listAllUserNoValidate.add(dto);
        }

        return listAllUserNoValidate;
    }

    @Override
    public UserDto validateAccountService(UserDto dto) {
        UserEntity entity = this.toEntity(dto);
        entity.setVerified(true);

        repository.saveAndFlush(entity);

        UserDto returnDto = new UserDto();
        returnDto = this.toDto(entity);

        return returnDto;
    }

    public UserDto getUserProfil(String username) {
        UserEntity entity = repository.findProfilByUsername(username);
        UserDto dto = new UserDto();

        dto = this.toDto(entity);

        return dto;
    }
}
