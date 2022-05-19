package com.example.covoit.service;

import com.example.covoit.dto.RoleDto;
import com.example.covoit.entity.RoleEntity;

public interface IRoleService {

    RoleDto toDto (RoleEntity entity);

}
