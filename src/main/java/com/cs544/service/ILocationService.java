package com.cs544.service;

import com.cs544.domain.Location;

import java.util.List;

public interface ILocationService {

    public void save(Location location);
    List<Location> findAll();
}
