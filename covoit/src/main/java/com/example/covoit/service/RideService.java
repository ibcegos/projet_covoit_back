package com.example.covoit.service;

import com.example.covoit.dto.*;
import com.example.covoit.entity.RecurrentRideEntity;
import com.example.covoit.entity.RideEntity;
import com.example.covoit.entity.SimpleRideEntity;
import com.example.covoit.entity.UserEntity;
import com.example.covoit.repository.IRecurrentRepository;
import com.example.covoit.repository.IRideRepository;
import com.example.covoit.repository.ISimpleRepository;
import com.example.covoit.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Driver;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class RideService implements IRideService {

    @Autowired
    public IRideRepository rideRepository;

    @Autowired
    public ISimpleRepository simpleRepository;

    @Autowired
    public IRecurrentRepository recurrentRepository;


    @Autowired
    public IUserRepository userRepository;
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

        for (int i = 0; i < entity.getSimpleList().size(); i++) {
            simpleRide.setDateAller(entity.getSimpleList().get(i).getDateAller());
            simpleRide.setTimeAller(entity.getSimpleList().get(i).getTimeAller());
            simpleRide.setTimeRetour(entity.getSimpleList().get(i).getTimeRetour());
            simpleRideList.add(simpleRide);
        }
        dto.setSimpleList(simpleRideList);

        List<RecurrentRideDto> recurrentRideList = new ArrayList();

        for (int i = 0; i < entity.getRecurrentList().size(); i++) {
            RecurrentRideDto recurrentRide = new RecurrentRideDto();
            recurrentRide.setJourAller(entity.getRecurrentList().get(i).getJourAller());
            recurrentRide.setTimeAller(entity.getRecurrentList().get(i).getTimeAller());
            recurrentRide.setTimeRetour(entity.getRecurrentList().get(i).getTimeRetour());
            recurrentRideList.add(i, recurrentRide);
        }
        dto.setRecurrentList(recurrentRideList);

        return dto;
    }

    @Override
    public RideDto toDtoConnected(RideEntity entity) {
        RideDto dto = new RideDto();


        dto.setId(entity.getId());
        dto.setDeparture(entity.getDeparture());
        dto.setDestination(entity.getDestination());
        dto.setSeats(entity.getSeats());
        dto.setVehicule_type(entity.getVehicleType());
        dto.setRideType(entity.getRideType());

//        List<DriverDto> listUserDto = new ArrayList();
//        for (int i = 0; i < entity.getDriversList().size(); i++) {
//
//            DriverDto driverDto = new DriverDto();
//            driverDto.setId(entity.getDriversList().get(i).getId());
//            driverDto.
//
//
//            listUserDto.add(driverDto);
//
//        }
//        dto.setDriversList(listUserDto);



        List<SimpleRideDto> simpleRideList = new ArrayList();
        SimpleRideDto simpleRide = new SimpleRideDto();

        for (int i = 0; i < entity.getSimpleList().size(); i++) {
            simpleRide.setDateAller(entity.getSimpleList().get(i).getDateAller());
            simpleRide.setTimeAller(entity.getSimpleList().get(i).getTimeAller());
            simpleRide.setTimeRetour(entity.getSimpleList().get(i).getTimeRetour());
            simpleRideList.add(simpleRide);
        }
        dto.setSimpleList(simpleRideList);

        List<RecurrentRideDto> recurrentRideList = new ArrayList();

        for (int i = 0; i < entity.getRecurrentList().size(); i++) {
            RecurrentRideDto recurrentRide = new RecurrentRideDto();
            recurrentRide.setJourAller(entity.getRecurrentList().get(i).getJourAller());
            recurrentRide.setTimeAller(entity.getRecurrentList().get(i).getTimeAller());
            recurrentRide.setTimeRetour(entity.getRecurrentList().get(i).getTimeRetour());
            recurrentRideList.add(i, recurrentRide);
        }
        dto.setRecurrentList(recurrentRideList);

        return dto;
    }




    @Override
    public List<RideDto> getRides() {
        List<RideEntity> rideList = rideRepository.findAll();
        List<RideDto> listAllRide = new ArrayList<>();

        for (RideEntity entity : rideList) {
            RideDto dto = this.toDto(entity);
            listAllRide.add(dto);
        }
        return listAllRide;
    }



 //------------- Proposition de trajet --------------------//

    //-----Création et sauvegarde d'une entité de trajet-----//
    @Override
    public Integer createRide(RideDto dto) {
        RideEntity entity = this.toEntity(dto);
        List<SimpleRideEntity> simple = entity.getSimpleList();
        List<RecurrentRideEntity> recurrent = entity.getRecurrentList();
        entity.setCreatedAt(LocalDateTime.now());
        try {
            rideRepository.saveAndFlush(entity);
            for (int i = 0;i< simple.size();i++){
                simpleRepository.saveAndFlush(simple.get(i));
            }
            for (int i = 0;i< recurrent.size();i++){
                if (null != recurrent.get(i).getTimeAller()) {
                    recurrentRepository.saveAndFlush(recurrent.get(i));
                }
            }
            return entity.getId();
        } catch(Exception e) {
            return null;
        }
    }
    //-----Passage d'un dto à une entité-----//
    @Override
    public RideEntity toEntity(RideDto dto) {
        RideEntity entity = new RideEntity();
        entity.setDeparture(dto.getDeparture());
        entity.setDestination("Boulot !");
        entity.setSeats(dto.getSeats());
        entity.setVehicleType(dto.getVehicule_type());
        entity.setRideType(dto.getRideType());

        //--------------------Trajet Simple----------//

        List<SimpleRideEntity> simpleRideList = new ArrayList();

        for (int i = 0; i < dto.getSimpleList().size(); i++) {
            SimpleRideEntity simpleRide = new SimpleRideEntity();
            simpleRide.setSimpleRide(entity);
            simpleRide.setDateAller(dto.getSimpleList().get(i).getDateAller());
            simpleRide.setTimeAller(dto.getSimpleList().get(i).getTimeAller());
            simpleRide.setTimeRetour(dto.getSimpleList().get(i).getTimeRetour());

            simpleRideList.add(simpleRide);
        }
        entity.setSimpleList(simpleRideList);

        //--------------------Trajet Récurrent----------//

        List<RecurrentRideEntity> recurrentRideList = new ArrayList();

        for (int i = 0; i < dto.getRecurrentList().size(); i++) {

            RecurrentRideEntity recurrentRide = new RecurrentRideEntity();
            recurrentRide.setRecurrentRide(entity);
            recurrentRide.setJourAller(dto.getRecurrentList().get(i).getJourAller());
            recurrentRide.setTimeAller(dto.getRecurrentList().get(i).getTimeAller());
            recurrentRide.setTimeRetour(dto.getRecurrentList().get(i).getTimeRetour());
            recurrentRideList.add(i, recurrentRide);
        }
        entity.setRecurrentList(recurrentRideList);

        return entity;
    }


//    @Override
//    public List<RideDto> getRidesByUser() {
//        List<RideEntity> rideList = rideRepository.findDriverByUsername();
//        List<RideDto> listRideUser = new ArrayList<>();
//
//        for (RideEntity entity : rideList) {
//            RideDto dto = this.toDtoConnected(entity);
//            listRideUser.add(dto);
//        }
//        return listRideUser;
//    }

    // delete recurrent rides from ride
//    @Override
//    public void deleteRecurrentRides(Integer id) {
//        List<RecurrentRideEntity> recurrentRideList = recurrentRepository.findRecurrentRideByRideId(id);
//        for (int i = 0; i < recurrentRideList.size(); i++) {
//            recurrentRepository.delete(recurrentRideList.get(i));
//        }
//    }


}




