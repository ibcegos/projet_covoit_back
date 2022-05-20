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
        dto.setRideType(entity.getRideType());

        List<SimpleRideDto> simpleRideList = new ArrayList();
        SimpleRideDto simpleRide = new SimpleRideDto();
        for (int i=0; i<entity.getSimpleList().size(); i++) {
            simpleRide.setDateAller(entity.getSimpleList().get(i).getDateAller());
            simpleRide.setTimeAller(entity.getSimpleList().get(i).getTimeAller());
            simpleRide.setTimeRetour(entity.getSimpleList().get(i).getTimeRetour());
            simpleRideList.add(simpleRide);
        }
        dto.setSimpleList(simpleRideList);

        List<RecurrentRideDto> recurrentRideList = new ArrayList();
        RecurrentRideDto recurrentRide = new RecurrentRideDto();

        for (int i=0; i<entity.getRecurrentList().size(); i++) {
            recurrentRide.setJourAller(entity.getRecurrentList().get(i).getJourAller());
            recurrentRide.setTimeAller(entity.getRecurrentList().get(i).getTimeAller());
            recurrentRide.setTimeRetour(entity.getRecurrentList().get(i).getTimeRetour());
            recurrentRideList.add(recurrentRide);
        }
        dto.setRecurrentList(recurrentRideList);

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
