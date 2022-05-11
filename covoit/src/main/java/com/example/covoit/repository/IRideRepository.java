package com.example.covoit.repository;

import com.example.covoit.entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRideRepository extends JpaRepository<RideEntity, Integer> {

}
