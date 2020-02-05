package com.cs544;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cs544.controller.FacultyController;
import com.cs544.dao.RecordRepository;
import com.cs544.dao.SessionRepository;
import com.cs544.dao.StudentRepository;
import com.cs544.domain.Location;
import com.cs544.domain.Record;
import com.cs544.domain.Role;
import com.cs544.domain.Session;
import com.cs544.domain.Student;
import com.cs544.domain.Timeslot;
import com.cs544.service.LocationService;

@SpringBootApplication

public class Cs544202001EarthApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(Cs544202001EarthApplication.class, args);
//			FacultyController facultyController = new FacultyController();
//			List<Student> students = facultyController.viewAttendanceBySession("1");
//	    	for(Student  s : students)
//	    	{
//	    		System.out.println(s.getFirsName());
//	    	}
	}


}
