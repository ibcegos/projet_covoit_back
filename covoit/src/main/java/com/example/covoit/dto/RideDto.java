package com.example.covoit.dto;

import com.example.covoit.entity.DriversEntity;
import com.example.covoit.entity.SimpleRideEntity;

import java.util.ArrayList;
import java.util.List;

public class RideDto {

    private Integer id;
    private String departure;
    private String destination;
    private String vehicule_type;
    private Integer seats;
    private String rideType;
    private List<DriverDto> driversList=new ArrayList<>();
    private List<SimpleRideDto> simpleList = new ArrayList<>();
    private List<RecurrentRideDto> recurrentList = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getVehicule_type() {
        return vehicule_type;
    }

    public void setVehicule_type(String vehicule_type) {
        this.vehicule_type = vehicule_type;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public List<SimpleRideDto> getSimpleList() {
        return simpleList;
    }

    public void setSimpleList(List<SimpleRideDto> simpleList) {
        this.simpleList = simpleList;
    }

    public List<RecurrentRideDto> getRecurrentList() {
        return recurrentList;
    }

    public void setRecurrentList(List<RecurrentRideDto> recurrentList) {
        this.recurrentList = recurrentList;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }


    public List<DriverDto> getDriversList() {
        return driversList;
    }

    public void setDriversList(List<DriverDto> driversList) {
        this.driversList = driversList;
    }

    @Override
    public String toString() {
        return "RideDto{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", vehicule_type='" + vehicule_type + '\'' +
                ", seats=" + seats +
                ", rideType='" + rideType + '\'' +
                ", driversList=" + driversList +
                ", simpleList=" + simpleList +
                ", recurrentList=" + recurrentList +
                '}';
    }
}

