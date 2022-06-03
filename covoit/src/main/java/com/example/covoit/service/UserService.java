package com.example.covoit.service;

import com.example.covoit.dto.RoleDto;
import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.ERole;
import com.example.covoit.entity.RoleEntity;
import com.example.covoit.entity.UserEntity;
import com.example.covoit.repository.IRoleRepository;
import com.example.covoit.repository.IUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    public IUserRepository repository;

    @Autowired
    public IRoleRepository roleRepository;


//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto toDto(UserEntity entity) {
        UserDto dto = new UserDto();
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(entity, dto);


        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setConnect(entity.getConnect());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setAvatar(entity.getAvatar());
        dto.setRoles(entity.getRoles());
        dto.setVerified(entity.getVerified());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    @Override
    public UserEntity toEntity(UserDto dto) {
        RoleEntity userRole = new RoleEntity();
        BeanUtils.copyProperties(dto, userRole);
        userRole.setName(ERole.User);
        userRole.setId(1L);

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
        entity.setRoles(Collections.singleton(userRole));

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
//            String psswd = dto.getPassword();
//            dto.setPassword(passwordEncoder.encode(psswd));
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

    @Override
    public UserDto loadUserByUsername(String username) {
        UserEntity user = repository.findUserByUsername(username);
        return this.toDto(user);

    }




//        return this.toDto((UserEntity) repository.findUserByPseudo(pseudo));



}
