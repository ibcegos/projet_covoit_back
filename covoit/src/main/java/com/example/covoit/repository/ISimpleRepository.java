package com.example.covoit.repository;

import com.example.covoit.entity.RideEntity;
import com.example.covoit.entity.SimpleRideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISimpleRepository extends JpaRepository<SimpleRideEntity, Integer> {
}
