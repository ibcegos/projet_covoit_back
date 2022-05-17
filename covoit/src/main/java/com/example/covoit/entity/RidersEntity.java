package com.example.covoit.entity;

import javax.persistence.*;

@Entity
@Table(name="Riders")
public class RidersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_riders_ride_id")
    private RideEntity ride;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_riders_user_id")
    private UserEntity userRide;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RideEntity getRide() {
        return ride;
    }

    public void setRide(RideEntity ride) {
        this.ride = ride;
    }

    public UserEntity getUser() {
        return userRide;
    }

    public void setUser(UserEntity userRide) {
        this.userRide = userRide;
    }

    @Override
    public String toString() {
        return "RidersEntity{" +
                "id=" + id +
                ", ride=" + ride +
                ", userRide=" + userRide +
                '}';
    }
}
