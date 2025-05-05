package dev.banturoots.connect.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;


public class EventDTO {

    @NotNull
    @Size(min = 1, max = 100)
    private String title;
    @NotNull
    private String category;
    @NotNull
    private String description;
    @NotNull
    private String location;
    @NotNull
    private LocalDateTime date;

    public EventDTO() {
    }

    public EventDTO(String title, String category, String description, String location, LocalDateTime date) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.location = location;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
