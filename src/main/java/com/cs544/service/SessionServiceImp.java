package com.cs544.service;

import com.cs544.dao.SessionRepository;
import com.cs544.domain.Session;
import com.cs544.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class SessionServiceImp implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;
    
    @Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<Student> getStudentsbySession(String sessionID) {
	    	 Session session = sessionRepository.getSessionBysessionID(sessionID);
	    	 List<Student> students =
	    	 session.getRecords().stream()
	    	 .map(r -> r.getStudent()).collect(Collectors.toList());
    	 return students;	
    	}
    @Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<Session> getSessions() {
		// TODO Auto-generated method stub	
    	List<Session> sessions = (List<Session>) sessionRepository.findAll();
    		return sessions;
    	}


}
