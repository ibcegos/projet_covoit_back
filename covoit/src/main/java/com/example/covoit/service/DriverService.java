package com.example.covoit.service;

import com.example.covoit.dto.DriverDto;
import com.example.covoit.entity.DriversEntity;
import com.example.covoit.repository.IDriverRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService implements  IDriverService {

    @Autowired
    public IDriverRepository driverRepository;


    @Override
    public List<DriversEntity> getDriverRide() {


        return driverRepository.findDriverByUsername();

    }

//    @Override
//    public DriverDto toDto(DriversEntity entity) {
//        DriverDto dto = new DriverDto();
//        RideDto rideDto = new RideDto();
//        UserDto userDto = new UserDto();
//
//        rideDto.setId(entity.getRide().getId());
//        rideDto.setDeparture(entity.getRide().getDeparture());
//        rideDto.setDestination(entity.getRide().getDestination());
//        rideDto.setDateAller(entity.getRide().getDateAller());
//
//        rideDto.setTimeAller(entity.getRide().getTimeAller());
//        rideDto.setTimeRetour(entity.getRide().getTimeRetour());
//        rideDto.setRideType(entity.getRide().getRideType());
//        dto.setId(entity.getId());
//        dto.setVehicleType(entity.getVehiculeType());
//        dto.setSeats(entity.getSeat());
//        //dto.setUser(entity.getUser());
//        dto.setRide(rideDto);
//        dto.setUser(userDto);
//        userDto.setId(entity.getUser().getId());
//        userDto.setFirstName(entity.getUser().getFirstName());
//        userDto.setLastName(entity.getUser().getLastName());
//        userDto.setEmail(entity.getUser().getEmail());
//        userDto.setPassword(entity.getUser().getPassword());
//        userDto.setPseudo(entity.getUser().getPseudo());
//        //userDto.setRole(entity.getUser().getRole());
//        userDto.setPhoneNumber(entity.getUser().getPhoneNumber());
//        userDto.setAvatar(entity.getUser().getAvatar());
//        //userDto.setConnect(entity.getUser().getConnect());
//
//        //BeanUtils.copyProperties(entity, dto);
//
//        return dto;
//
//    }

    @Override
    public DriversEntity toEntity(DriverDto dto) {
        DriversEntity entity = new DriversEntity();
        //entity.setId(dto.getId());
        //entity.setVehiculeType(dto.getVehicleType());
        //entity.setSeat(dto.getSeats());
        //entity.setUser(dto.getUser());
        //entity.setRide(dto.getRide());
        BeanUtils.copyProperties(dto, entity);


        return entity;
    }




//    @Override
//    public List<DriverDto> getDrivers() {
//        //List<DriversEntity> drivers = driverRepository.findAll();
//        List<DriversEntity> driversList = driverRepository.findAll();
//        List<DriverDto> listAlldrivers = new ArrayList<>();
//        for (int i=0; i<driversList.size(); i++){
//            DriversEntity entity = driversList.get(i);
//            DriverDto dto = this.toDto(entity);
//            listAlldrivers.add(dto);
//        }
//        return listAlldrivers;
//        //return drivers.stream().map(this::toDto).collect(java.util.stream.Collectors.toList());
//
//    }
}
