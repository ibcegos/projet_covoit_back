package com.example.covoit.dto;

import com.example.covoit.entity.RideEntity;


public class DriverDto {

    private Integer id;
    private RideDto ride;
    private UserDto user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                ", ride=" + ride +
                ", user=" + user +
                '}';
    }
}



