package com.cs544.dao;

import com.cs544.domain.Timeslot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends CrudRepository<Timeslot,Long> {
}
