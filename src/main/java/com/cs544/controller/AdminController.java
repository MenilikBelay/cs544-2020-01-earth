package com.cs544.controller;

import com.cs544.domain.Location;
import com.cs544.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/")
    public String locations(Location location ){
        return "admin";

    }

    @RequestMapping(value = "/locations",method = RequestMethod.POST)
    public String save(Location location ){
        locationService.save(location);
        return "redirect:/locationlist";
    }
    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public List<Location> findAll(){
        return locationService.findAll();
    }
}
