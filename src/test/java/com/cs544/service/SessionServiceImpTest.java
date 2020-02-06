package com.cs544.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cs544.dao.CourseOfferingRepository;
import com.cs544.dao.RegisterRepository;
import com.cs544.domain.Course;
import com.cs544.domain.CourseOffering;
import com.cs544.domain.Location;
import com.cs544.domain.Person;
import com.cs544.domain.PersonRole;
import com.cs544.domain.Register;
import com.cs544.domain.Session;
import com.cs544.domain.Student;
import com.cs544.domain.Timeslot;

import static org.mockito.ArgumentMatchers.*;

class SessionServiceImpTest {
	
	@InjectMocks
	private SessionServiceImp sessionServiceImp;
	@Mock
	private PersonService personService;
	@Mock
	private CourseOfferingRepository courseOfferingDao;
	@Mock
	private RegisterRepository registerDao;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetStudentSessionsByCourseOfferingId() {
		Student student = new Student("abc", "barcode");
		List<PersonRole> personRoles = new ArrayList<PersonRole>();
		personRoles.add(student);
		Person person = new Person("x@x.com", "abc", "x", "y", personRoles);
		List<Session> sessions = new ArrayList<Session>();
		sessions.add(
				new Session(new Location("Dolby", "Dolby"), 
						new Timeslot(), Calendar.getInstance().getTime()));
		CourseOffering courseOffering = new CourseOffering("cs544-01", 
				Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 
				new Course(1, "cs544", "EA"), sessions
				);
		Register register = new Register();
		register.setOfferedCourses(courseOffering);
		register.setStudent(student);
		when(personService.getStudentFromEmail(anyString())).thenReturn(Optional.ofNullable(student));
		when(courseOfferingDao.findByCourseOfferingID(anyString())).thenReturn(Optional.ofNullable(courseOffering));
		when(registerDao.findByCourseOfferingAndStudent(courseOffering, student)).thenReturn(Optional.ofNullable(register));
		assertEquals(register.getStudent().getBarcode(), student.getBarcode());
		assertEquals(register.getOfferedCourses().getCourseOfferingID(), courseOffering.getCourseOfferingID());
	}

}
