package com.example.covoit.service;


import com.example.covoit.dto.RoleDto;
import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.ContactEntity;
import com.example.covoit.entity.RoleEntity;
import com.example.covoit.entity.UserEntity;
import com.example.covoit.repository.IContactRepository;
import com.example.covoit.repository.IRoleRepository;
import com.example.covoit.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class AccountService implements IAccountService {

@Autowired
private IRoleRepository roleRepository;

@Autowired
private IUserRepository userRepository;

@Autowired
private IContactRepository contactRepository;

@Autowired
private PasswordEncoder passwordEncoder;

    @Override
    public UserDto toDto(UserEntity entity) {
        UserDto dto = new UserDto();

        // a for loop to get the roles to set the roleDto

        List<RoleDto> listRoleDto = new ArrayList<>();

        if(entity.getRoles() != null){
            for (int i = 0; i < entity.getRoles().size(); i++)  {
                RoleDto roleDto = new RoleDto();
                roleDto.setId(entity.getRoles().get(i).getId());
                roleDto.setRoleName(entity.getRoles().get(i).getRoleName());
                listRoleDto.add(roleDto);
            }
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
        dto.setRole(listRoleDto);
        dto.setVerified(entity.getVerified());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    @Override
    public UserEntity toEntity(UserDto dto) {
        RoleEntity userRole = new RoleEntity();
//        userRole.setRoleName("User");
//        userRole.setId(1);

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
//        List<RoleEntity> listRoleEntity = new ArrayList<>();
//        listRoleEntity.add(userRole);
//        entity.setRoles(listRoleEntity);
        entity.setPassword(dto.getPassword());
        entity.setAvatar(dto.getAvatar());
        entity.setVerified(false);
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }



    @Override
    public RoleEntity addNewRole(RoleEntity role) {
        return roleRepository.save(role);
    }

    @Override
    public UserEntity addNewUser(UserDto user) {
        UserEntity entity = this.toEntity(user);
        List<RoleEntity> userRole = roleRepository.findByRoleNameList("User");
        entity.setRoles(userRole);
        entity.setCreatedAt(LocalDateTime.now());
        try {
            String pw=entity.getPassword();
            entity.setPassword(passwordEncoder.encode(pw));
            userRepository.saveAndFlush(entity);
            return entity;
        } catch(Exception e) {
            return null;
        }


    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        UserEntity user = userRepository.findByUsername(username);
        RoleEntity role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public UserEntity loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> userList =userRepository.findAll();
        List<UserDto> listAllUser = new ArrayList<>();

        for (int i =0; i < userList.size(); i++) {
            UserEntity entity = userList.get(i);
            UserDto dto = this.toDto(entity);
            listAllUser.add(dto);
        }
        return listAllUser;
    }

    @Override
    public UserDto validateAccountService(UserDto dto) {
        UserEntity entity = this.toEntity(dto);
        entity.setVerified(true);

        userRepository.saveAndFlush(entity);

        UserDto returnDto = new UserDto();
        returnDto = this.toDto(entity);

        return returnDto;
    }

    @Override
    public UserDto deleteUserService(Integer id) {
        UserEntity entity = new UserEntity();
        entity = userRepository.getUserByIdTest(id);
        UserDto dto = new UserDto();
        dto = toDto(entity);
        userRepository.deleteById(id);
        return dto;
    }

    @Override
    public List<UserDto> getUserToValidate() {
        List<UserEntity> userToValidate = userRepository.findByUserNoValidate();
        List<UserDto> listAllUserNoValidate = new ArrayList<>();

        for (int i =0; i < userToValidate.size(); i++) {
            UserEntity entity = userToValidate.get(i);
            UserDto dto = this.toDto(entity);
            listAllUserNoValidate.add(dto);
        }

        return listAllUserNoValidate;
    }

    @Override
    public UserDto updateUserService(UserDto dto) {
        UserEntity entity = toEntity(dto);
        entity = userRepository.saveAndFlush(entity);

        return toDto(entity);
    }

    @Override
    public String getUserByUsername(String username) {
        UserEntity entity = userRepository.findByUsername2(username);
        String pseudo = entity.getUsername();
        return pseudo;
    }

    @Override
    public void sendMessage(ContactEntity contact) {
        contactRepository.saveAndFlush(contact);
    }

    @Override
    public List<ContactEntity> getAllContact() {
        return contactRepository.findAll();
    }


}

