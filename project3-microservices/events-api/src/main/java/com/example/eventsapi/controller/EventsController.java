package com.example.eventsapi.controller;

import com.example.eventsapi.model.Event;
import com.example.eventsapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class EventsController {

    @Autowired
    private EventService eventService;

    @GetMapping("/all")
    public Iterable<Event> getAll() {
        return eventService.getAll();
    }

    @GetMapping("/view/{id}")
    public Event searchById(@PathVariable long id) {
        return eventService.searchById(id);
    }

    @GetMapping("/search/{name}")
    public Iterable<Event> searchByName(@PathVariable String name) {
        return eventService.searchByName(name);
    }

    @PostMapping("/create")
    public HttpStatus createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteEvent(@PathVariable long id) {
        return eventService.deleteEvent(id);
    }

    @PatchMapping("/update/{id}")
    public HttpStatus updateEvent(@PathVariable long id, @RequestBody Event eventRequest) {
        return eventService.updateEvent(id, eventRequest);
    }
}
