package com.example.eventsapi.service;

import com.example.eventsapi.model.Event;
import org.springframework.http.HttpStatus;

public interface EventService {
    public Iterable<Event> getAll();

    public Event searchById(long id);

    public Iterable<Event> searchByName(String name);

    public HttpStatus createEvent(Event event);

    public HttpStatus deleteEvent(long id);

    public HttpStatus updateEvent(long id, Event eventRequest);
}
