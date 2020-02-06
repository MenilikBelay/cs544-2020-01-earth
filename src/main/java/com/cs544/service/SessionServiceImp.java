package com.cs544.service;

import com.cs544.dao.CourseOfferingRepository;
import com.cs544.dao.RegisterRepository;
import com.cs544.dao.SessionRepository;
import com.cs544.domain.CourseOffering;
import com.cs544.domain.Location;
import com.cs544.domain.Record;
import com.cs544.domain.Register;
import com.cs544.domain.Session;
import com.cs544.domain.Student;
import com.cs544.exception.ResourceNotFoundException;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service

public class SessionServiceImp implements SessionService {

    @Autowired
    private SessionRepository sessionDao;
    @Autowired
    private PersonService personService;
    @Autowired 
    private CourseOfferingRepository courseOfferingDao;
    @Autowired
    private RegisterRepository registerDao;
    
    @Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<Student> getStudentsbySession(String sessionID) {
	    	 Session session = sessionDao.getSessionBysessionID(sessionID);
	    	 List<Student> students =
	    	 session.getRecords().stream()
	    	 .map(r -> r.getStudent()).collect(Collectors.toList());
    	 return students;	
    	}
    @Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<Session> getSessions() {
		// TODO Auto-generated method stub	
    	List<Session> sessions = (List<Session>) sessionDao.findAll();
    		return sessions;
    	}
    
    /**
     * Returns the sessions a student attended for a given course offering
     * @param personId : the email address of current user [must be authenticated and have Student role]
     * @param courseOfferingId : course offering id
     * @return list of sessions the student attended for the given course. Might throw exception if 
     * resources are not found
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Session> getStudentSessionsByCourseOfferingId (String personId, String courseOfferingId) {
    	Student student = personService.getStudentFromEmail(personId).orElseThrow(
    			() -> new ResourceNotFoundException("Student", 
    					"person id", personId));
    	CourseOffering courseOffering = courseOfferingDao.findByCourseOfferingID(courseOfferingId)
    			.orElseThrow(() -> new ResourceNotFoundException("Course Offering", 
    					"courseOffering", courseOfferingId));
    	Register register = registerDao.findByCourseOfferingAndStudent(courseOffering, student)
    			.orElseThrow(() -> new ResourceNotFoundException("Register", 
    					"Course Offering --> Student", "")); // now we are sure that student is registered for the course offering
    	List<Session> sessions = courseOffering.getSession();
    	return sessions.parallelStream()
    				.filter(s -> 
    					s.getRecords().parallelStream()
    						.filter(r -> r.getStudent().getStudentID().equals(student.getStudentID()))
    						.findAny()
    						.isPresent()
    				)
    				.collect(Collectors.toList());
    }
}
