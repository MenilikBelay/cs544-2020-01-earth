package com.cs544.dao;
import com.cs544.domain.Record;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends CrudRepository<Record,Long> {
}
