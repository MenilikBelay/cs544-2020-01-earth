package com.cs544.service;

import com.cs544.dao.SessionRepository;
import com.cs544.domain.Location;
import com.cs544.domain.Record;
import com.cs544.domain.Session;
import com.cs544.domain.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service

public class SessionServiceImp implements SessionService {

    @Autowired
    private SessionRepository sessionDao;
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public List<Student> getStudentsbySession(String sessionID) {
	    	 List<Session>sessions = (List<Session>) sessionDao.findAll();
	    	 List<Student> students =
	    	 sessions.stream().filter( s-> s.getSessionId().equals(sessionID))
	    	 .flatMap(s-> s.getRecords().stream())
	    	 .map(r -> r.getStudent()).collect(Collectors.toList());
    	 return students;	
    	}
    @Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public List<Session> getSessions() {
		// TODO Auto-generated method stub	
    	List<Session> sessions = (List<Session>) sessionDao.findAll();
    		return sessions;
    	}


}
