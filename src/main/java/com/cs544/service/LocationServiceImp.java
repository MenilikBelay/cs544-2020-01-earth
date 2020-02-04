package com.cs544.service;

import com.cs544.dao.ILocationDao;
import com.cs544.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class LocationServiceImp implements ILocationService {

    @Autowired
    private ILocationDao locationDao;
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Location location) {
        locationDao.save(location);
    }

    @Override

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Location> findAll() {

        return locationDao.findAll();
    }

}