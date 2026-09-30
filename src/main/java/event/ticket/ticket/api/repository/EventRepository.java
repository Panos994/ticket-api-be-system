package event.ticket.ticket.api.repository;

import event.ticket.ticket.api.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
    List<Event> findByEventDateAfter(LocalDateTime date);
    List<Event> findByTitleContainingIgnoreCase(String title);

}
