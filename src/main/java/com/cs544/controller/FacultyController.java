package com.cs544.controller;

import com.cs544.domain.Location;
import com.cs544.domain.Session;
import com.cs544.domain.Student;
import com.cs544.service.SessionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/faculty")
public class FacultyController {
	
	@Autowired
	SessionService sessionService;
	
    @RequestMapping(value = "/")
    public String initiate(Location location ){
        return "faculty";

    }    
    
    @RequestMapping(value = "/session_students" , method = RequestMethod.GET)
    public List<Student> viewAttendanceBySession(String sessionID) {  		
    	List<Student> students = sessionService.getStudentsbySession(sessionID);
    	return students;
    }
    @RequestMapping(value = "/sessions" , method = RequestMethod.GET)
    public List<Session> getSessions(String sessionID) {  		
    	List<Session> sessions = sessionService.getSessions(sessionID);
    	return sessions;
    }
}