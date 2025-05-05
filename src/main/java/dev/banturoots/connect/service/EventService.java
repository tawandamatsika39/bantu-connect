package dev.banturoots.connect.service;

import dev.banturoots.connect.entity.Event;
import dev.banturoots.connect.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event event) {
        Event existingEvent = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));

        existingEvent.setTitle(event.getTitle());
        existingEvent.setLocation(event.getLocation());
        existingEvent.setCategory(event.getCategory());
        existingEvent.setDate(event.getDate());

        return eventRepository.save(existingEvent);
    }

    public boolean deleteEvent(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Event> getEventsByCategory(String category) {
        return eventRepository.findByCategory(category);
    }


    public List<Event> getEventsByLocation(String location) {
        return eventRepository.findByLocation(location);
    }

    public List<Event> getEventsByCategoryAndLocation(String category, String location) {
        return eventRepository.findByCategoryAndLocation(category, location);
    }

    public List<Event> getEventsAfterDate(LocalDateTime date) {
        return eventRepository.findByDateAfter(date);
    }


    public List<Event> getEventsByLocationWithPagination(String location, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return eventRepository.findByLocation(location, pageRequest);
    }
}
