package com.example.covoit.repository;

import com.example.covoit.entity.RideEntity;
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

//    @Query(value = "SELECT r.departure, r.ride_type, r.seats, r.vehicule_type," +
//            " s.date_Aller, s.time_Aller, s.time_Retour FROM Rides r " +
//            "INNER JOIN Simples s ON s.FK_ride_id = r.id " +
//            "INNER JOIN Drivers d ON d.FK_ride_id = r.id " +
//            "INNER JOIN Users u ON u.id_user = d.FK_user_id WHERE u.username=?", nativeQuery = true)
//    List<RideEntity> findSimpleRideByUsername(String username);
//
//    @Query(value = "SELECT r.departure, r.ride_type, r.seats, r.vehicule_type," +
//            " rec.jour_Aller, rec.time_Aller, rec.time_Retour FROM Rides r " +
//            "INNER JOIN Recurrents rec ON rec.FK_ride_id = r.id " +
//            "INNER JOIN Drivers d ON d.FK_ride_id = r.id " +
//            "INNER JOIN Users u ON u.id_user = d.FK_user_id WHERE u.username=?", nativeQuery = true)
//    List<RideEntity> findRecurrentRideByUsername(String username);

    @Query(value = "SELECT * FROM Users u WHERE u.username = ? " , nativeQuery = true )
    UserEntity findProfilByUsername(String username);
}

