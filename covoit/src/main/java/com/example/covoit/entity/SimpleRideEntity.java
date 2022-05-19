package com.example.covoit.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="SimpleRides")
public class SimpleRideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="date_Aller")
    private LocalDate dateAller;

    @Column(name="time_Aller")
    private LocalTime timeAller;

    @Column(name="time_Retour")
    private LocalTime timeRetour;

    @OneToMany(mappedBy = "simpleRide")
    private List<SimpleRideEntity> simpleList;


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

    public List<SimpleRideEntity> getSimpleList() {
        return simpleList;
    }

    public void setSimpleList(List<SimpleRideEntity> simpleList) {
        this.simpleList = simpleList;
    }

    @Override
    public String toString() {
        return "SimpleRideEntity{" +
                "id=" + id +
                ", dateAller=" + dateAller +
                ", timeAller=" + timeAller +
                ", timeRetour=" + timeRetour +
                ", simpleList=" + simpleList +
                '}';
    }
}
