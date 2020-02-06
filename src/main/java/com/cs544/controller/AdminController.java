package com.cs544.controller;

import com.cs544.dao.PersonRepository;
import com.cs544.domain.Course;
import com.cs544.domain.Location;
import com.cs544.domain.Person;
import com.cs544.domain.Student;
import com.cs544.domain.CourseOffering;
import com.cs544.domain.Timeslot;
import com.cs544.service.CourseService;
import com.cs544.service.CourseofferingService;
import com.cs544.service.LocationService;
import com.cs544.service.StudentService;
import com.cs544.service.TimeSlotService;
import com.cs544.service.UserDetailsServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        courseofferingService.getCourseOfferingById(id);

    }
    @GetMapping("/courseofferings/{id}")
    public CourseOffering getCourseOfferingById(@PathVariable(value = "id") String courseId){
        return  courseofferingService.getCourseOfferingById(courseId);
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
