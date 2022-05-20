package com.example.covoit.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class SimpleRideDto {

    private Integer id;
    private LocalDate dateAller;
    private LocalTime timeAller;
    private LocalTime timeRetour;

    private RideDto ride;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateAller() {
        return dateAller;
    }

    public void setDateAller(LocalDate dateAller) {
        this.dateAller = dateAller;
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

    public RideDto getRide() {
        return ride;
    }

    public void setRide(RideDto ride) {
        this.ride = ride;
    }

    @Override
    public String toString() {
        return "SimpleRideDto{" +
                "id=" + id +
                ", dateAller=" + dateAller +
                ", timeAller=" + timeAller +
                ", timeRetour=" + timeRetour +
                ", ride=" + ride +
                '}';
    }
}
