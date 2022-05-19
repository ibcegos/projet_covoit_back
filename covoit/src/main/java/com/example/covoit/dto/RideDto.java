package com.example.covoit.dto;

public class RideDto {

    private Integer id;
    private String departure;
    private String destination;
    private String dateAller ;

    private String timeAller ;
    private String timeRetour ;
    private String rideType ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimeAller() {
        return timeAller;
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

    public String getDateAller() {
        return dateAller;
    }

    public void setDateAller(String dateAller) {
        this.dateAller = dateAller;
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

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    @Override
    public String toString() {
        return "RideDto{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", dateAller='" + dateAller + '\'' +

                ", timeAller='" + timeAller + '\'' +
                ", timeRetour='" + timeRetour + '\'' +
                ", rideType='" + rideType + '\'' +
                '}';
    }
}
