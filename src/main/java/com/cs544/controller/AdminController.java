package com.cs544.controller;

import com.cs544.domain.Course;
import com.cs544.domain.Location;
import com.cs544.domain.Timeslot;
import com.cs544.service.CourseService;
import com.cs544.service.LocationService;
import com.cs544.service.TimeSlotService;
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
    @Autowired
    TimeSlotService timeSlotService;

    //........course crud start..............
    @PostMapping("/courses")
    public Course add(@Valid @RequestBody Course course){

        return  courseService.add(course);
    }
    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable(value = "id") String courseId){
       return  courseService.getCourseById(courseId);
    }

   @DeleteMapping("/courses/{id}")
   public void deleteCourseById(@PathVariable(value = "id") String id){
        courseService.deleteCourseById(id);

   }
   @PutMapping("/courses/{id}")
   public Course update(@PathVariable(value = "id") String courseId,@Valid @RequestBody Course course){
        return courseService.update(courseId,course);
   }
    //........course crud end..............

    //........timeslot crud start..............

    @PostMapping("/timeslots")
    public Timeslot add(@Valid @RequestBody Timeslot timeslot){

        return  timeSlotService.add(timeslot);
    }
   /* @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable(value = "id") String courseId){
        return  courseService.getCourseById(courseId);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourseById(@PathVariable(value = "id") String id){
        courseService.deleteCourseById(id);

    }
    @PutMapping("/courses/{id}")
    public Course update(@PathVariable(value = "id") String courseId,@Valid @RequestBody Course course){
        return courseService.update(courseId,course);
    }*/
    //........timeslot crud end...............
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
