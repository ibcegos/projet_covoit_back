package com.example.covoit.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Rides")
public class RideEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="date_Aller")
    private String dateAller;

    @Column(name="date_Retour")
    private String dateRetour;


    @Column(name="time_Aller")
    private String timeAller;

    @Column(name="time_Retour")
    private String timeRetour;


    @Column(name="departure")
    private String departure;

    @Column(name="destination")
    private String destination;

    @Column(name="ride_type")
    private String rideType;

    @OneToMany(mappedBy = "ride")
    private List<DriversEntity> driverList = new ArrayList<>();

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name="deleted_at")
    private LocalDateTime deletedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateAller() {
        return dateAller;
    }

    public void setDateAller(String dateAller) {
        this.dateAller = dateAller;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }

    public String getTimeAller() {
        return timeAller;
    }

    public void setTimeAller(String timeAller) {
        this.timeAller = timeAller;
    }

    public String getTimeRetour() {
        return timeRetour;
    }

    public void setTimeRetour(String timeRetour) {
        this.timeRetour = timeRetour;
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

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public List<DriversEntity> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<DriversEntity> driverList) {
        this.driverList = driverList;
    }

    @Override
    public String toString() {
        return "RideEntity{" +
                "id=" + id +
                ", dateAller='" + dateAller + '\'' +
                ", dateRetour='" + dateRetour + '\'' +
                ", timeAller='" + timeAller + '\'' +
                ", timeRetour='" + timeRetour + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", rideType='" + rideType + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }

}
