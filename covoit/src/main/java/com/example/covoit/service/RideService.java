package com.example.covoit.service;

import com.example.covoit.dto.RecurrentRideDto;
import com.example.covoit.dto.RideDto;
import com.example.covoit.dto.SimpleRideDto;
import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.RecurrentRideEntity;
import com.example.covoit.entity.RideEntity;
import com.example.covoit.entity.SimpleRideEntity;
import com.example.covoit.entity.UserEntity;
import com.example.covoit.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public IDriverRepository driverRepository;

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
//--------------------Récupérer les trajets d'un utilisateur pour l'afficher dans son profil-----------------//
    @Override
    public List<RideDto> getRides(String currentusername) {
        List<RideEntity> simpleRideList = rideRepository.findSimpleRideByUsername(currentusername);
        List<RideEntity> recurrentRideList = rideRepository.findRecurrentRideByUsername(currentusername);

        List<RideDto> listAllRide = new ArrayList<>();

        for (RideEntity entity : simpleRideList) {
            RideDto dto = this.toDto(entity);
            listAllRide.add(dto);
        }
        for (RideEntity entity : recurrentRideList) {
            RideDto dto = this.toDto(entity);
            listAllRide.add(dto);
        }
        return listAllRide;
    }

//---------------Supprimer un trajet ---------------------//

    @Override
    public RideDto deleteRideService(Integer id) {
        RideEntity entity = new RideEntity();
        entity = rideRepository.getRideById(id);
        RideDto dto = new RideDto();
        dto = toDto(entity);

        for(int i = 0 ; i < entity.getRecurrentList().size() ; i++){
                recurrentRepository.deleteById(entity.getRecurrentList().get(i).getId());
        }
        for(int i = 0 ; i < entity.getSimpleList().size() ; i++){
            simpleRepository.deleteById(entity.getSimpleList().get(i).getId());
        }
        for(int i = 0 ; i < entity.getDriverList().size() ; i++){
            driverRepository.deleteById(entity.getDriverList().get(i).getId());
        }
        rideRepository.deleteById(id);
        return dto;
    }
}




