package dev.banturoots.connect.controller;

import dev.banturoots.connect.dto.EventDTO;
import dev.banturoots.connect.entity.Event;
import dev.banturoots.connect.service.EventService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class EventGraphQLResolver {
    private final EventService eventService;

    public EventGraphQLResolver(EventService eventService) {
        this.eventService = eventService;
    }

    @QueryMapping
    public List<Event> events() {
        return eventService.getAllEvents();
    }

    @QueryMapping
    public List<Event> eventsByCategory(@Argument String category) {
        return eventService.getEventsByCategory(category);
    }

    @QueryMapping
    public List<Event> eventsByLocation(@Argument String location) {
        return eventService.getEventsByLocation(location);
    }

    @MutationMapping
    public Event createEvent(@Argument("input") EventDTO input
    ) {
        Event event = new Event();
        event.setTitle(input.getTitle());
        event.setDescription(input.getDescription());
        event.setCategory(input.getCategory());
        event.setLocation(input.getLocation());
        event.setDate(input.getDate()); // or change type if needed
        return eventService.createEvent(event);
    }
}
