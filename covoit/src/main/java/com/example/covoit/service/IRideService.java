package com.example.covoit.service;

import com.example.covoit.dto.RideDto;
import com.example.covoit.entity.RideEntity;

import java.util.List;

public interface IRideService {

    RideDto toDto(RideEntity entity);

    List<RideDto> getRides();


}
