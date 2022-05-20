package com.example.covoit.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="trajet_recurrent")
public class RecurrentRideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="jour_Aller")
    private String jourAller;

    @Column(name="time_Aller")
    private LocalTime timeAller;

    @Column(name="time_Retour")
    private LocalTime timeRetour;

    @OneToMany(mappedBy = "recurrentRide")
    private List<RideEntity> rideList;

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

    public List<RideEntity> getRideList() {
        return rideList;
    }

    public void setRideList(List<RideEntity> rideList) {
        this.rideList = rideList;
    }

    @Override
    public String toString() {
        return "RecurrentRideEntity{" +
                "id=" + id +
                ", jourAller='" + jourAller + '\'' +
                ", timeAller=" + timeAller +
                ", timeRetour=" + timeRetour +
                ", rideList=" + rideList +
                '}';
    }
}
