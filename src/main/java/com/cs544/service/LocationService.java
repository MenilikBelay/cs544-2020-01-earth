package com.cs544.service;

import com.cs544.domain.Location;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface LocationService {

    public void save(Location location);
    List<Location> findAll();
    public void update(Location location);
    public ResponseEntity<?> delete(Location location);

}
