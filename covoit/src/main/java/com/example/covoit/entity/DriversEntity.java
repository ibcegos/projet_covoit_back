package com.example.covoit.entity;

import javax.persistence.*;

@Entity
@Table(name="Drivers")
public class DriversEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "FK_ride_id")
    private RideEntity ride;

    @ManyToOne
    @JoinColumn(name = "FK_user_id")
    private UserEntity user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                ", ride=" + ride +
                ", user=" + user +
                '}';
    }
}
