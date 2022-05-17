package com.example.covoit.dto;

import com.example.covoit.entity.RoleEntity;

import java.time.LocalDateTime;

public class UserDto {

    private Integer id;
    private String lastName;
    private String firstName;
    private String pseudo;
    private String password;
    private String email;
    private RoleDto role;
    private Boolean isConnect;
    private String phoneNumber;
    private String avatar;
    private Boolean verified;
    private LocalDateTime createdAt;


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

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
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

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
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

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", isConnect=" + isConnect +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", avatar='" + avatar + '\'' +
                ", verified=" + verified +
                '}';
    }
}
