package com.example.covoit.service;

import com.example.covoit.dto.RecurrentRideDto;
import com.example.covoit.dto.RideDto;
import com.example.covoit.dto.SimpleRideDto;
import com.example.covoit.entity.RecurrentRideEntity;
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
        dto.setId(entity.getId());
        dto.setDeparture(entity.getDeparture());
        dto.setDestination(entity.getDestination());
        dto.setSeats(entity.getSeats());
        dto.setVehicule_type(entity.getVehicleType());

        SimpleRideDto simpleRide = new SimpleRideDto();
        simpleRide.setId(entity.getId());
        simpleRide.setDateAller(entity.getSimpleRide().getDateAller());
        simpleRide.setTimeAller(entity.getSimpleRide().getTimeAller());
        simpleRide.setTimeRetour(entity.getSimpleRide().getTimeRetour());
        dto.setSimpleRide(simpleRide);

        RecurrentRideDto recurrentRide = new RecurrentRideDto();
        recurrentRide.setId(entity.getId());
        recurrentRide.setJourAller(entity.getRecurrentRide().getJourAller());
        recurrentRide.setTimeAller(entity.getSimpleRide().getTimeAller());
        recurrentRide.setTimeRetour(entity.getRecurrentRide().getTimeRetour());
        dto.setRecurrentRide(recurrentRide);

        return dto;
    }
//    @Override
//    public RideEntity toEntity(RideDto dto) {
//        RideEntity entity = new RideEntity();
//        entity.setDeparture(dto.getDeparture());
//        entity.setDestination(dto.getDestination());
//        entity.setDateAller(dto.getDateAller());
//        entity.setRideType(dto.getRideType());
//        entity.setTimeRetour(dto.getTimeRetour());
//        entity.setTimeAller(dto.getTimeAller());
//        return entity;
//    }


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
