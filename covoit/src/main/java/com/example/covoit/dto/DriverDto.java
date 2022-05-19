package com.example.covoit.dto;

import com.example.covoit.entity.RideEntity;


public class DriverDto {

    private Integer id;
    private String vehicleType;
    private Integer seats;
    private RideDto ride;

    private UserDto user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public RideDto getRide() {
        return ride;
    }

    public void setRide(RideDto ride) {
        this.ride = ride;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "DriverDto{" +
                "id=" + id +
                ", vehicleType='" + vehicleType + '\'' +
                ", seats=" + seats +
                ", ride=" + ride +
                ", user=" + user +
                '}';
    }
}



