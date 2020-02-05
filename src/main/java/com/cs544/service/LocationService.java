package com.cs544.service;

import com.cs544.domain.Location;

import java.util.List;

public interface LocationService {

    public void save(Location location);
    List<Location> findAll();
    void update(Location location);
}
