package com.cs544.service;

import com.cs544.domain.Location;
import com.cs544.domain.Session;
import com.cs544.domain.Student;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface SessionService {

	public List<Student> getStudentsbySession(String sessionID);
	public List<Session> getSessions();

}
