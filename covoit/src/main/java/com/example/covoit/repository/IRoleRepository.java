package com.example.covoit.repository;

import com.example.covoit.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRoleRepository extends JpaRepository<RoleEntity,Long> {
    RoleEntity findByRoleName(String roleName);

@Query(value = "SELECT * FROM Roles r WHERE r.title = ?1", nativeQuery = true)
   List<RoleEntity> findByRoleNameList(String roleNames);
}
