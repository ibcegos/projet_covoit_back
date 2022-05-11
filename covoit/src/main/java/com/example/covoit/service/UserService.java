package com.example.covoit.service;

import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.UserEntity;
import com.example.covoit.repository.IUserRepository;
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
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPseudo(entity.getPseudo());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setConnect(entity.getConnect());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setAvatar(entity.getAvatar());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    @Override
    public UserEntity toEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPseudo(dto.getPseudo());
        entity.setEmail(dto.getEmail());
        entity.setConnect(false);
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setRole("User");
        entity.setPassword(dto.getPassword());
        entity.setAvatar(dto.getAvatar());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setVerified(false);
        return entity;
    }

    @Override
    public Integer createUser(UserDto dto) {
        UserEntity entity = new UserEntity();
        this.toEntity(dto);
        entity.setCreatedAt(LocalDateTime.now());
        try {
            repository.saveAndFlush(entity);
            return entity.getId();
        } catch(Exception e) {
            return null;
        }

    }

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
    public void validateAccountService(UserDto dto) {
        UserEntity entity = this.toEntity(dto);
        entity.setVerified(true);

        repository.saveAndFlush(entity);
    }


}
