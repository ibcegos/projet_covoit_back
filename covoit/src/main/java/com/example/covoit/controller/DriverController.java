package com.example.covoit.controller;

import com.example.covoit.dto.DriverDto;
import com.example.covoit.service.IDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("Covoit")
public class DriverController {
    @Autowired
    private IDriverService driverService;
    @GetMapping("/getdriver")
    public List<DriverDto> getDrivers(){
        return driverService.getDrivers();
    }

}






