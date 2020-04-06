package com.cs544.controller;

import com.cs544.domain.Location;

import com.cs544.domain.Session;
import com.cs544.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	
	@Autowired
	private SessionService sessionService;
	
    @RequestMapping(value = "/")
    public String locations(Location location ){
        return "student";
    }
    
    
    /**
     * Return the sessions a student attended in a given course offering
     * @param principal: Security object to read current user information
     * @param courseOfferingId: Id of course offering the user is interested in
     * @return List of sessions a student attended in a given course offering
     */
    @GetMapping("/courseofferings/{courseOfferingId}")
    public List<Session> getAttendanceRecord (@PathVariable String courseOfferingId, Principal principal) {
    	// Principal provides the authenticated and authorized email of student-person object
    	return sessionService.getStudentSessionsByCourseOfferingId(principal.getName(), courseOfferingId);
    }

}
