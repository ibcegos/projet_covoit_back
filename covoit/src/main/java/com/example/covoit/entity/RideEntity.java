package com.example.covoit.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Rides")
public class RideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="departure")
    private String departure;

    @Column(name="destination")
    private String destination;

    @Column(name="vehicule_type")
    private String vehicleType;

    @Column(name="seats")
    private Integer seats;

    @OneToMany(mappedBy = "ride")
    private List<DriversEntity> driversList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_simple_ride_id")
    private SimpleRideEntity simpleRide;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_recurrent_ride_id")
    private RecurrentRideEntity recurrentRide;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name="deleted_at")
    private LocalDateTime deletedAt;

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
        return driversList;
    }

    public void setDriverList(List<DriversEntity> driversList) {
        this.driversList = driversList;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public List<DriversEntity> getDriversList() {
        return driversList;
    }

    public void setDriversList(List<DriversEntity> driversList) {
        this.driversList = driversList;
    }

    public SimpleRideEntity getSimpleRide() {
        return simpleRide;
    }

    public void setSimpleRide(SimpleRideEntity simpleRide) {
        this.simpleRide = simpleRide;
    }

    public RecurrentRideEntity getRecurrentRide() {
        return recurrentRide;
    }

    public void setRecurrentRide(RecurrentRideEntity recurrentRide) {
        this.recurrentRide = recurrentRide;
    }

    @Override
    public String toString() {
        return "RideEntity{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", seats=" + seats +
                ", driversList=" + driversList +
                ", simpleRide=" + simpleRide +
                ", recurrentRide=" + recurrentRide +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
