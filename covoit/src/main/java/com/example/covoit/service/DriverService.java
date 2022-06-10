package com.example.covoit.service;

import com.example.covoit.dto.DriverDto;
import com.example.covoit.dto.RideDto;
import com.example.covoit.dto.UserDto;
import com.example.covoit.entity.DriversEntity;
import com.example.covoit.repository.IDriverRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService implements  IDriverService {

    @Autowired
    public IDriverRepository driverRepository;




    @Override
    public DriverDto toDto(DriversEntity entity) {
        DriverDto dto = new DriverDto();
        RideDto rideDto = new RideDto();
        UserDto userDto = new UserDto();

        rideDto.setId(entity.getRide().getId());
        rideDto.setDeparture(entity.getRide().getDeparture());
        rideDto.setDestination(entity.getRide().getDestination());
        rideDto.setRideType(entity.getRide().getRideType());
        dto.setId(entity.getId());
        dto.setRide(rideDto);



        userDto.setId(entity.getUser().getId());
        userDto.setFirstName(entity.getUser().getFirstName());
        userDto.setLastName(entity.getUser().getLastName());
        userDto.setEmail(entity.getUser().getEmail());
        userDto.setPassword(entity.getUser().getPassword());
        userDto.setUsername(entity.getUser().getUsername());
        userDto.setPhoneNumber(entity.getUser().getPhoneNumber());
        userDto.setAvatar(entity.getUser().getAvatar());
        dto.setUser(userDto);



        return dto;

    }

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


    @Override
    public List<DriverDto> getDriverRide() {
        List<DriversEntity> driverList =driverRepository.findDriverByUsername();
        List<DriverDto> driverDtoList = new ArrayList<>();
        for (DriversEntity driver : driverList) {
            driverDtoList.add(toDto(driver));
        }
        return driverDtoList;


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
