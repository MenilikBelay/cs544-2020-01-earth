package com.cs544.service;

import com.cs544.dao.LocationRepository;
import com.cs544.domain.Location;
import com.cs544.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@Service

public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(@Valid Location location) {
        locationRepository.save(location);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Location> findAll() {
    	List<Location> locations = new ArrayList<Location>();
        locationRepository.findAll().forEach(locations::add);
        return locations;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(@Valid Location location) {
    	Location previousLocation = locationRepository.getLocationByLocationID(location.getLocationID()).orElseThrow(() -> new ResourceNotFoundException("Note", "id",location.getLocationID()));
    	previousLocation.setDescription(location.getDescription());
    	save(previousLocation);
    }

	@Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
	public ResponseEntity<?> delete(Location location) {
    	Location previousLocation = locationRepository.getLocationByLocationID(location.getLocationID()).orElseThrow(() -> new ResourceNotFoundException("Note", "id",location.getLocationID()));
	    locationRepository.delete(previousLocation);
        return ResponseEntity.ok().build();
	} 
}
