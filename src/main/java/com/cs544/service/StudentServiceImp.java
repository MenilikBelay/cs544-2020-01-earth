package com.cs544.service;

import com.cs544.dao.LocationRepository;
import com.cs544.dao.SessionRepository;
import com.cs544.dao.StudentRepository;
import com.cs544.domain.Course;
import com.cs544.domain.CourseOffering;
import com.cs544.domain.Location;
import com.cs544.domain.Student;
import com.cs544.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;



@Service
public class StudentServiceImp implements StudentService {
}
