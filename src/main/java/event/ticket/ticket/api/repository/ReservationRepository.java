package event.ticket.ticket.api.repository;

import event.ticket.ticket.api.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
    List<Reservation> findByEvent_EventDate(LocalDateTime eventDate); //to event entityexei event_date
    List<Reservation> findByCustomerEmail(String email);
    List<Reservation> findByEventId(UUID eventId);
}
