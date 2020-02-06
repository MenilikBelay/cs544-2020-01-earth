package com.cs544.service;

import com.cs544.domain.Timeslot;
import org.springframework.http.ResponseEntity;

public interface TimeSlotService {

    public Timeslot add(Timeslot course);
    public ResponseEntity<?> deleteById(Long id);

    public Timeslot update(Long id, Timeslot timeslot);
    public Timeslot getTimeSlotById(Long id);
}