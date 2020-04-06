package com.cs544.dao;
import com.cs544.domain.Session;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SessionRepository extends CrudRepository<Session,Long> {
   public Optional<Session> getSessionBysessionID(String sessionId);
}
