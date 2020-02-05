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
    @Transactional(propagation = Propagation.REQUIRED)
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

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(Location location) {
    	List<Location> locations = new ArrayList<Location>();
    	locations =  (List<Location>) locationDao.findAll();
    	boolean flag = false;
    	for(Location loc : locations)
    	{
    		if(loc.getLocationID().equals(location.getLocationID()))
    		{loc.setDescription(location.getDescription());
    		flag = true;}
    	}if(flag == false)
	    	{
    			save(location);
	    	}
    }
  /*  
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean delet() {
    	List<Location> locations = new ArrayList<Location>();
        locationDao.findAll().forEach(locations::add);
        return locations;
    }
     */ 
}
