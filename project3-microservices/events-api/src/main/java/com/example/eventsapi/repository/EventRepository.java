package com.example.eventsapi.repository;

import com.example.eventsapi.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository <Event, Long> {
    List<Event> findByNameContaining(String normalized, String name);
    List<Event> findByDateExists(String date);
    List<Event> findByDescriptionContaining(String content);
}
