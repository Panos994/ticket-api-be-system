package event.ticket.ticket.api.service;

import event.ticket.ticket.api.dto.CreateReservationRequestDTO;
import event.ticket.ticket.api.dto.CreateReservationResponseDTO;
import event.ticket.ticket.api.entity.Event;
import event.ticket.ticket.api.entity.Reservation;
import event.ticket.ticket.api.repository.EventRepository;
import event.ticket.ticket.api.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final EventRepository eventRepository;

    public ReservationService(ReservationRepository reservationRepository, EventRepository eventRepository) {
        this.reservationRepository = reservationRepository;
        this.eventRepository = eventRepository;
    }
    @Transactional
    public CreateReservationResponseDTO createReservation(CreateReservationRequestDTO dto){
        Event event = eventRepository.findById(dto.getEventId()).orElseThrow(()-> new IllegalArgumentException("Event not found with this id: " + dto.getEventId()));
        Reservation reservation = new Reservation();
        if(event.getAvailableTickets() < dto.getTicketCount()){
            throw new IllegalArgumentException("Not enough tickets available for this event.");
        }
        BigDecimal totalPrice = event.getPricePerTicket().multiply(BigDecimal.valueOf(dto.getTicketCount()));
        reservation.setTicketCount(dto.getTicketCount());
        reservation.setTotalPrice(totalPrice);
        reservation.setCustomerEmail(dto.getCustomerEmail());
        reservation.setEvent(event);
        event.setAvailableTickets(event.getAvailableTickets() - dto.getTicketCount());
        Reservation savedReservation = reservationRepository.save(reservation);


        return CreateReservationResponseDTO.builder()
                .eventId(savedReservation.getEvent().getId())
                .customerEmail(savedReservation.getCustomerEmail())
                .ticketCount(savedReservation.getTicketCount())
                .totalPrice(savedReservation.getTotalPrice())
                .createdAt(savedReservation.getCreatedAt())
                .build();
    }
    @Transactional
    public void cancelReservation(UUID reservationId){
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(()-> new IllegalArgumentException("Reservation not found with this id: " + reservationId));
        Event event = reservation.getEvent();
        event.setAvailableTickets(event.getAvailableTickets() + reservation.getTicketCount());
        reservationRepository.delete(reservation);

    }
}
