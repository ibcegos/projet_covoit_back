package com.example.covoit.repository;

import com.example.covoit.entity.DriversEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IDriverRepository extends JpaRepository<DriversEntity, Integer> {
}
