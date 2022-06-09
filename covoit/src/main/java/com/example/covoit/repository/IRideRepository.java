package com.example.covoit.repository;

import com.example.covoit.entity.RideEntity;
import com.example.covoit.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRideRepository extends JpaRepository<RideEntity, Integer> {




}
