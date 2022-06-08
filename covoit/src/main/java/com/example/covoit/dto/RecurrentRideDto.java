package com.example.covoit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

public class RecurrentRideDto {

    private Integer id;
    private String jourAller;

//    @JsonFormat(pattern="hh:mm")
    private LocalTime timeAller;
//    @JsonFormat(pattern="hh:mm")
    private LocalTime timeRetour;


//    private RideDto ride;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJourAller() {
        return jourAller;
    }

    public void setJourAller(String jourAller) {
        this.jourAller = jourAller;
    }

    public LocalTime getTimeAller() {
        return timeAller;
    }

    public void setTimeAller(LocalTime timeAller) {
        this.timeAller = timeAller;
    }

    public LocalTime getTimeRetour() {
        return timeRetour;
    }

    public void setTimeRetour(LocalTime timeRetour) {
        this.timeRetour = timeRetour;
    }

//    public RideDto getRide() {
//        return ride;
//    }
//
//    public void setRide(RideDto ride) {
//        this.ride = ride;
//    }

    @Override
    public String toString() {
        return "RecurrentRideDto{" +
                "id=" + id +
                ", jourAller='" + jourAller + '\'' +
                ", timeAller=" + timeAller +
                ", timeRetour=" + timeRetour +
//                ", ride=" + ride +
                '}';
    }
}
