package com.cs544.controller;

import com.cs544.domain.Location;
import com.cs544.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private ILocationService locationService;

    @RequestMapping(value = "/")
    public String locations(Location location ){
        return "redirect:/locationlist";

    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Location location ){
//        Location  location=new Location();
//        location.setDescription("dalby hall");
        locationService.save(location);
//        Location  location2=new Location();
//        location2.setDescription("142 bld");
//        locationService.save(location2);

        return "redirect:/locationlist";
    }
    @RequestMapping(value = "/locationlist", method = RequestMethod.GET)
    public List<Location> findAll(){
        return locationService.findAll();
    }









}
