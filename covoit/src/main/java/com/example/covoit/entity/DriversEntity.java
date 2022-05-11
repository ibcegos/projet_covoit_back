package com.example.covoit.entity;

import javax.persistence.*;

@Entity
@Table(name="Drivers")
public class DriversEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="vehicule_type")
    private String vehiculeType;

    @Column(name="seats")
    private Integer seat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ride_id")
    private RideEntity ride;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_user_id")
    private UserEntity user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehiculeType() {
        return vehiculeType;
    }

    public void setVehiculeType(String vehiculeType) {
        this.vehiculeType = vehiculeType;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public RideEntity getRide() {
        return ride;
    }

    public void setRide(RideEntity ride) {
        this.ride = ride;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "DriversEntity{" +
                "id=" + id +
                ", vehiculeType='" + vehiculeType + '\'' +
                ", seat=" + seat +
                ", ride=" + ride +
                ", user=" + user +
                '}';
    }
}
