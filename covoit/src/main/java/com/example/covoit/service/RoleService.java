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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    public IUserRepository repository;



    @Override
    public RoleDto toDtoRole(RoleEntity entity) {
        RoleDto dto = new RoleDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }
    @Override
    public UserDto toDtoUser(UserEntity entity) {
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





    //create a role to a user
    @Override
    public void createRoleToUser(String username, ERole name) {

        UserEntity user = repository.findUserByUsername(username);
        Optional<RoleEntity> role = roleRepository.findByName(name);
        if(role.isPresent()){
            RoleEntity roleEntity = role.get();
            UserDto dto = new UserDto();
            //if the role name is USER then we add the role to the user
            if(roleEntity.getName().equals(ERole.User)){
                user.setRoles(new HashSet<RoleEntity>());
                user.getRoles().add(roleEntity);
                repository.save(user);
            } else if(roleEntity.getName().equals(ERole.Admin)){
                user.setRoles(new HashSet<RoleEntity>());
                user.getRoles().add(roleEntity);
                repository.save(user);
            } else if(roleEntity.getName().equals(ERole.Moderator)){
                user.setRoles(new HashSet<RoleEntity>());
                user.getRoles().add(roleEntity);
                repository.save(user);
            }
        }

    }


    @Override
    public List<RoleDto> getAllRoles() {
        List<RoleDto> dtos = new ArrayList<>();
        roleRepository.findAll().forEach(entity -> dtos.add(toDtoRole(entity)));
        return dtos;
    }

    @Override
    public RoleDto getRoleById(Long id) {
        Optional<RoleEntity> entity = roleRepository.findById(id);
        return entity.map(this::toDtoRole).orElse(null);
    }

    @Override
    public RoleDto updateRole(RoleDto dto) {
        Optional<RoleEntity> entity = roleRepository.findByName(dto.getName());
        if(entity.isPresent()){
            RoleEntity roleEntity = entity.get();
            roleEntity.setName(dto.getName());
            roleRepository.saveAndFlush(roleEntity);
            return toDtoRole(roleEntity);
        }
        return null;
    }


}





