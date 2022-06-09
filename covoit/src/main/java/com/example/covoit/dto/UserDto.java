package com.example.covoit.dto;

import com.example.covoit.entity.DriversEntity;
import com.example.covoit.entity.RoleEntity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public class UserDto {

    private Integer id;
    private String lastName;
    private String firstName;
    private String username;
    private String password;
    private String email;
    private List<RoleDto> role;
    private Boolean isConnect;
    private String phoneNumber;
    private String avatar;
    private Boolean verified;
    private LocalDateTime createdAt;

    private List<DriversEntity> driversList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<RoleDto> getRole() {
        return role;
    }

    public void setRole(List<RoleDto> role) {
        this.role = role;
    }

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


    public List<DriversEntity> getDriversList() {
        return driversList;
    }

    public void setDriversList(List<DriversEntity> driversList) {
        this.driversList = driversList;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", isConnect=" + isConnect +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", avatar='" + avatar + '\'' +
                ", verified=" + verified +
                ", createdAt=" + createdAt +
                ", driversList=" + driversList +
                '}';
    }
}
