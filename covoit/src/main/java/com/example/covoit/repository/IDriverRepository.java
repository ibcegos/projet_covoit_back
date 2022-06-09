package com.example.covoit.repository;

import com.example.covoit.entity.DriversEntity;
import com.example.covoit.entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IDriverRepository extends JpaRepository<DriversEntity, Integer> {


    @Query(value = "SELECT * FROM Rides r " +
            "INNER JOIN Drivers d ON d.FK_ride_id = r.id " +
            "INNER JOIN Users u ON u.id_user = d.FK_user_id ", nativeQuery = true)
    List<DriversEntity> findDriverByUsername();
}
