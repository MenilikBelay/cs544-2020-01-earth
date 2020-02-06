package com.cs544.controller;

import com.cs544.domain.Session;
import com.cs544.domain.Student;
import com.cs544.domain.Timeslot;
import com.cs544.service.CourseofferingService;
import com.cs544.service.SessionService;
import com.cs544.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/faculty")
public class FacultyController {
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	private TimeSlotService timeSlotService;
	
    @Autowired
    CourseofferingService courseofferingService;   
    
    @RequestMapping(value = "/sessions/{id}", method = RequestMethod.GET)
    public List<Student> viewAttendanceBySession(@PathVariable(value = "id") String sessionID) {
    	List<Student> students = sessionService.getStudentsbySession(sessionID);
    	return students;
    }
    @RequestMapping(value = "/sessions" , method = RequestMethod.GET)
    public List<Session> getSessions() {  		
    	List<Session> sessions = sessionService.getSessions();
    	return sessions;
    }
    
    @RequestMapping(value = "/courseOfferings/{id}", method = RequestMethod.GET)
    public String courseOfferingAttendances(@PathVariable(value="id") String courseOfferingId){
    	System.out.println("Entering the FacultyController ...");
        String percentage =  courseofferingService.getCourseOfferingAttendances(courseOfferingId);
        return percentage;
    }
    
    @RequestMapping(value="/timeslots", method = RequestMethod.GET)
    public List<Timeslot> findAllTimeslot(){
    	return timeSlotService.findAll();
    }
}