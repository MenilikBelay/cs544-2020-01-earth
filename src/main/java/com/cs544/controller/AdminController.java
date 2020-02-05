package com.cs544.controller;

import com.cs544.domain.Course;
import com.cs544.domain.Location;
import com.cs544.service.CourseService;
import com.cs544.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private LocationService locationService;
    @Autowired
    CourseService courseService;

    @PostMapping("/courses")
    public Course add(@Valid @RequestBody Course course){

        return  courseService.add(course);
    }


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
