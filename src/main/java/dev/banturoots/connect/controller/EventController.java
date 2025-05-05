package dev.banturoots.connect.controller;

import dev.banturoots.connect.dto.EventDTO;
import dev.banturoots.connect.entity.Event;
import dev.banturoots.connect.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;


    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }


    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }


    @PostMapping
    public Event createEvent(@Valid @RequestBody EventDTO eventDTO) {
        Event event = new Event();
        event.setTitle(eventDTO.getTitle());
        event.setCategory(eventDTO.getCategory());
        event.setLocation(eventDTO.getLocation());
        event.setDate(eventDTO.getDate());
        return eventService.createEvent(event);
    }


    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @Valid @RequestBody EventDTO updatedEventDTO) {

        Event updatedEvent = new Event();
        updatedEvent.setTitle(updatedEventDTO.getTitle());
        updatedEvent.setCategory(updatedEventDTO.getCategory());
        updatedEvent.setLocation(updatedEventDTO.getLocation());
        updatedEvent.setDate(updatedEventDTO.getDate());

        return eventService.updateEvent(id, updatedEvent);
    }


    @DeleteMapping("/{id}")
    public boolean deleteEvent(@PathVariable Long id) {
        return eventService.deleteEvent(id);
    }

    @GetMapping("/category/{category}")
    public List<Event> getEventsByCategory(@PathVariable String category) {
        return eventService.getEventsByCategory(category);
    }

    @GetMapping("/location/{location}")
    public List<Event> getEventsByLocation(@PathVariable String location) {
        return eventService.getEventsByLocation(location);
    }

    @GetMapping("/location/{location}/page")
    public List<Event> getEventsByLocationWithPagination(@PathVariable String location,
                                                         @RequestParam int page,
                                                         @RequestParam int size) {
        return eventService.getEventsByLocationWithPagination(location, page, size);
    }
}
