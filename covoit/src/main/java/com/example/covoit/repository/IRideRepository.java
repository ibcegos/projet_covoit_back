package com.example.covoit.repository;

import com.example.covoit.entity.RideEntity;
import com.example.covoit.entity.RoleEntity;
import com.example.covoit.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRideRepository extends JpaRepository<RideEntity, Integer> {
    @Query(value = "SELECT * FROM Rides r " +
            "INNER JOIN Simples s ON s.FK_ride_id = r.id " +
            "INNER JOIN Drivers d ON d.FK_ride_id = r.id " +
            "INNER JOIN Users u ON u.id_user = d.FK_user_id WHERE u.username=?", nativeQuery = true)
    List<RideEntity> findSimpleRideByUsername(String username);


    @Query(value = "SELECT * FROM Rides r " +
            "INNER JOIN Recurrents rec ON rec.FK_ride_id = r.id " +
            "INNER JOIN Drivers d ON d.FK_ride_id = r.id " +
            "INNER JOIN Users u ON u.id_user = d.FK_user_id WHERE u.username=?", nativeQuery = true)
    List<RideEntity> findRecurrentRideByUsername(String username);

    @Query(value = "SELECT * FROM Rides r WHERE r.id = ? " , nativeQuery = true )
    RideEntity getRideById(Integer id);


    @Query(value = "SELECT * FROM Rides r WHERE r.departure = ?1", nativeQuery = true)
    List<RideEntity> findRideEntityByDeparture(String departure);



}
