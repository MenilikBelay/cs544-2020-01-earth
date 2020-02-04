package com.cs544.dao;

import com.cs544.domain.Location;
import org.springframework.data.repository.CrudRepository;


public interface LocationRepository extends CrudRepository<Location,Long> {
}
