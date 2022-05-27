package com.example.covoit.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity

@Table(name="Simples")

public class SimpleRideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;


    @Column(name="date_Aller")
    private LocalDate dateAller;

    @JsonFormat(pattern="hh:mm")
    @Column(name="time_Aller")
    private LocalTime timeAller;

    @JsonFormat(pattern="hh:mm")
    @Column(name="time_Retour")
    private LocalTime timeRetour;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ride_id")
    private RideEntity simpleRide;



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

    public RideEntity getSimpleRide() {
        return simpleRide;
    }

    public void setSimpleRide(RideEntity simpleRide) {
        this.simpleRide = simpleRide;
    }

    @Override
    public String toString() {
        return "SimpleRideEntity{" +
                "id=" + id +
                ", dateAller=" + dateAller +
                ", timeAller=" + timeAller +
                ", timeRetour=" + timeRetour +
                ", simpleRide=" + simpleRide +
                '}';
    }
}
