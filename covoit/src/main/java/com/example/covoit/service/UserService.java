package com.example.covoit.service;

import com.example.covoit.dto.CreateUserDto;
import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.UserEntity;
import com.example.covoit.repository.IUserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPseudo(entity.getPseudo());
        dto.setEmail(entity.getEmail());
        dto.setConnect(entity.getConnect());
        dto.setPhoneNumber(entity.getPhoneNumber());
        return dto;
    }

    @Override
    public Integer createUser(CreateUserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPseudo(dto.getPseudo());
        entity.setEmail(dto.getEmail());
        entity.setConnect(false);
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setRole("User");
        entity.setPassword(dto.getPassword());
        entity.setAvatar(dto.getAvatar());
        entity.setVerified(false);
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


}
