package com.example.covoit.repository;

import com.example.covoit.entity.RecurrentRideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecurrentRepository extends JpaRepository<RecurrentRideEntity, Integer> {
}
