package com.example.covoit.service;

import com.example.covoit.dto.RideDto;
import com.example.covoit.entity.RideEntity;
import com.example.covoit.repository.IRideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service

public class RideService implements IRideService {

    @Autowired
    public IRideRepository rideRepository;

    @Override
    public RideDto toDto(RideEntity entity) {
        RideDto dto = new RideDto();
        dto.setDeparture(entity.getDeparture());
        dto.setDestination(entity.getDestination());
        dto.setDateAller(entity.getDateAller());

        dto.setRideType(entity.getRideType());
        dto.setTimeRetour(entity.getTimeRetour());
        dto.setTimeAller(entity.getTimeAller());

        return dto;
    }
    @Override
    public RideEntity toEntity(RideDto dto) {
        RideEntity entity = new RideEntity();
        entity.setDeparture(dto.getDeparture());
        entity.setDestination(dto.getDestination());
        entity.setDateAller(dto.getDateAller());
        entity.setRideType(dto.getRideType());
        entity.setTimeRetour(dto.getTimeRetour());
        entity.setTimeAller(dto.getTimeAller());
        return entity;
    }


    @Override
    public List<RideDto> getRides() {
        List<RideEntity> rideList = rideRepository.findAll();
        List<RideDto> listAllRide = new ArrayList<>();

        for (int i =0; i < rideList.size(); i++) {
            RideEntity entity = rideList.get(i);
            RideDto dto = this.toDto(entity);
            listAllRide.add(dto);
        }
        return listAllRide;
    }


}
