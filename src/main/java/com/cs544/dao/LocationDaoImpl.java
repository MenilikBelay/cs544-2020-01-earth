package com.cs544.dao;

import com.cs544.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
@Component
public class LocationDaoImpl implements LocationDao {

    @Autowired
    LocationRepository locationRepository;


    @Override
    public boolean save(Location location) {
        locationRepository.save(location);
        return true;
    }

    @Override
    public List<Location> findAll() {
     return (List<Location>) locationRepository.findAll();

    }
}
