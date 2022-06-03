package com.example.covoit.repository;

import com.example.covoit.dto.RoleDto;
import com.example.covoit.entity.ERole;
import com.example.covoit.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(ERole name);





}
