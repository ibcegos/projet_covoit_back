package com.example.covoit.dto;

import com.example.covoit.entity.ERole;

public class RoleDto {
    private Long id;

    private ERole name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
