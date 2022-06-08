package com.example.covoit.repository;

import com.example.covoit.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT * FROM Users u WHERE u.verified = 0 " , nativeQuery = true )
    List<UserEntity> findByUserNoValidate();

    UserEntity findByUsername(String username);
}

