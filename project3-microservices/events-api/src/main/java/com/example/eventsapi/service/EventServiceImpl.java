package com.example.eventsapi.service;

import com.example.eventsapi.model.Event;
import com.example.eventsapi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Iterable<Event> getAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event searchById(long id) {
        return eventRepository.findById(id).get();
    }

    @Override
    public List<Event> searchByName(String name) {
        String normalized = name.trim().toLowerCase();
        return eventRepository.findByNameContaining(normalized, normalized);
    }

    @Override
    public HttpStatus createEvent(Event event) {
        eventRepository.save(event);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus deleteEvent(long id) {
        eventRepository.deleteById(id);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus updateEvent(long id, Event eventRequest) {
        Event event = eventRepository.findById(id).get();
        event.setName(eventRequest.getName());
        event.setDate(eventRequest.getDate());
        event.setDescription(eventRequest.getDescription());
        eventRepository.save(event);
        return HttpStatus.OK;
    }
}
