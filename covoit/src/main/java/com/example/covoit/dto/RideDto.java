package com.example.covoit.dto;

public class RideDto {

    private Integer id;
    private String departure;
    private String destination;
    private String vehicule_type;
    private Integer seats;
    private SimpleRideDto simpleRide;
    private RecurrentRideDto recurrentRide;

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

    public SimpleRideDto getSimpleRide() {
        return simpleRide;
    }

    public void setSimpleRide(SimpleRideDto simpleRide) {
        this.simpleRide = simpleRide;
    }

    public RecurrentRideDto getRecurrentRide() {
        return recurrentRide;
    }

    public void setRecurrentRide(RecurrentRideDto recurrentRide) {
        this.recurrentRide = recurrentRide;
    }

    @Override
    public String toString() {
        return "RideDto{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", vehicule_type='" + vehicule_type + '\'' +
                ", seats=" + seats +
                ", simpleRide=" + simpleRide +
                ", recurrentRide=" + recurrentRide +
                '}';
    }
}
