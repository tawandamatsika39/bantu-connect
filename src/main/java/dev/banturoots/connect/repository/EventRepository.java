package dev.banturoots.connect.repository;

import dev.banturoots.connect.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByCategory(String category);

    List<Event> findByLocation(String location);

    List<Event> findByCategoryAndLocation(String category, String location);

    List<Event> findByDateAfter(LocalDateTime date);

    List<Event> findByLocation(String location, org.springframework.data.domain.PageRequest pageRequest);
}
