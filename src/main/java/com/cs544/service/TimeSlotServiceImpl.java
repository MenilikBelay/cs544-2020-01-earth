package com.cs544.service;

import com.cs544.dao.TimeSlotRepository;
import com.cs544.domain.Timeslot;
import com.cs544.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

         timeSlotRepository.deleteById(id);
         return ResponseEntity.ok().build();
    }

    @Override
    public Timeslot update(Long id, Timeslot timeslot) {
        Timeslot timeslot1=timeSlotRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Note", "id",id));
        timeslot1.setAbbrevition(timeslot.getAbbrevition());
        timeslot1.setBeginTime(timeslot.getBeginTime());
        timeslot1.setEndTime(timeslot.getEndTime());
        timeslot1.setDescription(timeslot.getDescription());
        return timeSlotRepository.save(timeslot1);
    }

    @Override
    public Timeslot getTimeSlotById(Long id) {
        Timeslot timeslot1=timeSlotRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Note", "id",id));
        return timeslot1;
    }
    
    @Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<Timeslot> findAll() {
		List<Timeslot> timeslots = new ArrayList<Timeslot>();
		timeSlotRepository.findAll().forEach(timeslots::add);
		return timeslots;
	}
}
