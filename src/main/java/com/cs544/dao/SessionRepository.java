package com.cs544.dao;
import com.cs544.domain.Session;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SessionRepository extends CrudRepository<Session,Long> {
   public Session getSessionBysessionID(String sessionId);
}
