package com.example.covoit.service;

import com.example.covoit.dto.DriverDto;
import com.example.covoit.entity.DriversEntity;

import java.util.List;

public interface IDriverService {

    //DriverDto toDto(DriversEntity entity);

    //List<DriverDto> getDrivers();

    DriversEntity toEntity(DriverDto dto);
}



