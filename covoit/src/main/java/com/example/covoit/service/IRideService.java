package com.example.covoit.service;

import com.example.covoit.dto.RecurrentRideDto;
import com.example.covoit.dto.RideDto;
import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.DriversEntity;
import com.example.covoit.entity.RecurrentRideEntity;
import com.example.covoit.entity.RideEntity;

import java.util.List;

public interface IRideService {

    RideDto toDto(RideEntity entity);



    // RideEntity toEntity(RideDto dto);

    RideDto toDtoConnected(RideEntity entity);

    List<RideDto> getRides();


    Integer createRide(RideDto dto);

    RideEntity toEntity(RideDto dto);

    List<RideDto> getRidesByDeparture(String departure);

//    List<RideDto> getRidesByUser();
}
