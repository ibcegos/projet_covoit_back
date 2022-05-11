package com.example.covoit.dto;

public class RideDto {

    private String id;
    private String departure;
    private String destination;
    private String dateAller ;
    private String dateRetour ;
    private String timeAller ;
    private String timeRetour ;
    private String rideType ;

    public String getId() {
        return id;
    }



    public void setId(String id) {
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

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
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
}
