package com.cs544.dao;
import com.cs544.domain.Location;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location,Long> {

public Optional<Location> getLocationByLocationID(String id);
}
