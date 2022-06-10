package com.example.covoit.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name="Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private Integer id;

    @Column(name="last_name")
    private String lastName;

    @Column(name="first_name")
    private String firstName;

    @Column(name="username")
    private String username;


    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "id_User"), inverseJoinColumns = @JoinColumn(name = "id_Role"))
    private List<RoleEntity> roles;


    @OneToMany(mappedBy = "user")
    private List<DriversEntity> driversList;

    @OneToMany(mappedBy = "userRide")
    private List<RidersEntity> riderList;

    @Column(name="is_connected")
    private Boolean isConnect;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="avatar")
    private String avatar;

    @Column(name="verified")
    private Boolean verified;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Boolean getConnect() {
        return isConnect;
    }

    public void setConnect(Boolean connect) {
        isConnect = connect;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatar() { return avatar; }

    public void setAvatar(String avatar) { this.avatar = avatar; }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
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

    public void setDriversList(List<DriversEntity> driversList) {
        this.driversList = driversList;
    }

    public List<RidersEntity> getRiderList() {
        return riderList;
    }

    public void setRiderList(List<RidersEntity> riderList) {
        this.riderList = riderList;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public List<DriversEntity> getDriversList() {
        return driversList;
    }



    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", driversList=" + driversList +
                ", riderList=" + riderList +
                ", isConnect=" + isConnect +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", avatar='" + avatar + '\'' +
                ", verified=" + verified +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
