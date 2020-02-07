package com.cs544.controller;

import com.cs544.domain.Course;
import com.cs544.domain.CourseOffering;
import com.cs544.domain.Location;
import com.cs544.domain.Timeslot;
import com.cs544.service.CourseService;
import com.cs544.service.CourseofferingService;
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
    @Autowired
    CourseofferingService courseofferingService;
        
    //........course crud start..............
    @PostMapping("/courses")
    public Course add( @RequestBody @Valid Course course){

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
   @GetMapping("/timeslots/{id}")
    public Timeslot getTimeSlotById(@PathVariable(value = "id") Long timeslotid){
        return  timeSlotService.getTimeSlotById(timeslotid);
    }

    @DeleteMapping("/timeslots/{id}")
    public void deleteTimeSlotById(@PathVariable(value = "id") Long id){
       timeSlotService.deleteById(id);

    }
    @PutMapping("/timeslots/{id}")
    public Timeslot update(@PathVariable(value = "id") Long timeslotid,@Valid @RequestBody Timeslot timeslot){
        return timeSlotService.update(timeslotid,timeslot);
    }
    //........timeslot crud end...............

    //...........courseoffering crud start..........
        @PostMapping("/courses/{id}/courseofferings")
        public CourseOffering add(@PathVariable(value = "id") String id, @Valid @RequestBody CourseOffering offerdCourses){

        return courseofferingService.add(offerdCourses,id);

        }
    @DeleteMapping("/courseofferings/{id}")
    public void deleteCourseOfferingById(@PathVariable(value = "id") String id){
        courseofferingService.deleteCourseOfferingById(id);

    }
    @GetMapping("/courseofferings/{id}")
    public CourseOffering getCourseOfferingById(@PathVariable(value = "id") String courseId){
        return  courseofferingService.getCourseOfferingById(courseId);
    }
   /* @GetMapping("/courses/{id}/courseofferings")
    public CourseOffering getCourseOfferingCourseById(@PathVariable(value = "id") String courseId){
        return  courseofferingService.getCourseOfferingByCourseId(courseId);
    }*/

    @PutMapping("/courseofferings/{id}")
    public CourseOffering update(@PathVariable(value = "id") String courseofferingId,@Valid @RequestBody CourseOffering courseOffering){
        return courseofferingService.update(courseofferingId,courseOffering);
    }
    //...........courseoffering crud end..........
    @RequestMapping(value = "/locations",method = RequestMethod.POST)
    public boolean save(@Valid Location location ){
        locationService.save(location);
        return true;
    }
    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public List<Location> findAll(){
        return locationService.findAll();
    }
    
   @RequestMapping(value = "/locations", method = RequestMethod.PUT)
    public boolean update(@Valid Location location){
        locationService.update(location);
        return true;
    }
   @RequestMapping(value = "/locations", method = RequestMethod.DELETE)
   public boolean delete(@Valid Location location){
       locationService.delete(location);
       return true;
   }
}
