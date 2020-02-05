package com.cs544.service;

import com.cs544.dao.TimeSlotRepository;
import com.cs544.domain.OfferedCourse;
import com.cs544.domain.Timeslot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class TimeSlotServiceImpl implements TimeSlotService {

    @Autowired
    TimeSlotRepository timeSlotRepository;
    @Override
    public Timeslot add(Timeslot timeslot) {

        return timeSlotRepository.save(timeslot);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        return null;
    }

    @Override
    public Timeslot update(Long id, Timeslot timeslot) {
        return null;
    }

    @Override
    public OfferedCourse getTimeSlotById(Long id) {
        return null;
    }
}
