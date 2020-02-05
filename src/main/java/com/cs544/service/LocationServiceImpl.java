package com.cs544.service;

import com.cs544.dao.LocationRepository;
import com.cs544.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service

public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationDao;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Location location) {
        locationDao.save(location);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Location> findAll() {
    	List<Location> locations = new ArrayList<Location>();
        locationDao.findAll().forEach(locations::add);
        return locations;
    }

}
