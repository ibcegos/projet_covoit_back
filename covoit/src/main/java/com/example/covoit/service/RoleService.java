package com.example.covoit.service;

import com.example.covoit.dto.RoleDto;
import com.example.covoit.entity.RoleEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {


    @Override
    public RoleDto toDto(RoleEntity entity) {
        RoleDto dto = new RoleDto();
        dto.setLibelle(entity.getTitle());
        return dto;
    }



}
