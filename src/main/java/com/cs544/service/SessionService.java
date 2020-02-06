package com.cs544.service;

import com.cs544.domain.Location;
import com.cs544.domain.Session;
import com.cs544.domain.Student;

import java.util.List;

public interface SessionService {

	public List<Student> getStudentsbySession(String sessionID);
	public List<Session> getSessions();
	public List<Session> getStudentSessionsByCourseOfferingId (String personId, String courseOfferingId);

}
