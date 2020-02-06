package com.cs544.service;

import com.cs544.domain.Timeslot;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

public interface TimeSlotService {

    public Timeslot add(@Valid Timeslot course);
    public ResponseEntity<?> deleteById(Long id);

    public Timeslot update(Long id, @Valid Timeslot timeslot);
    public Timeslot getTimeSlotById(Long id);
    public List<Timeslot> findAll();
}
