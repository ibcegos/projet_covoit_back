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

    //@Query(value = "SELECT username FROM Users WHERE username = ? ", nativeQuery = true)
    UserEntity findByUsername(String username);

    @Query(value = "SELECT * FROM Users u WHERE u.id_user = ?", nativeQuery = true )
    UserEntity getUserByIdTest(Integer id);

    @Query(value = "SELECT username FROM Users WHERE username = ? ", nativeQuery = true)
    UserEntity findByUsername2(String username);

    @Query(value = "SELECT * FROM Users u WHERE u.username = ? " , nativeQuery = true )
    UserEntity findProfilByUsername(String username);

}

