package event.ticket.ticket.api.service;

import event.ticket.ticket.api.dto.CreateEventRequestDTO;
import event.ticket.ticket.api.dto.CreateEventResponseDTO;
import event.ticket.ticket.api.entity.Event;
import event.ticket.ticket.api.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Transactional
    public CreateEventResponseDTO createEvent(CreateEventRequestDTO dto){
        Event event = new Event();

        event.setTitle(dto.getTitle());
        event.setDescription(dto.getDescription());
        event.setLocation(dto.getLocation());
        event.setAvailableTickets(dto.getTotalTickets());
        event.setPricePerTicket(dto.getPricePerTicket());
        event.setTotalTickets(dto.getTotalTickets());
        event.setEventDate(dto.getEventDate());

        eventRepository.save(event);
        return CreateEventResponseDTO.builder()
                .title(event.getTitle())
                .description(event.getDescription())
                .location(event.getLocation())
                .availableTickets(event.getAvailableTickets())
                .pricePerTicket(event.getPricePerTicket())
                .build();
    }
    public List<CreateEventResponseDTO> getAllEvents(){
        return eventRepository.findAll()
                .stream()
                .map(e-> CreateEventResponseDTO.builder()
                        .title(e.getTitle())
                        .description(e.getDescription())
                        .location(e.getLocation())
                        .availableTickets(e.getAvailableTickets())
                        .pricePerTicket(e.getPricePerTicket())
                        .build()).toList();

    }
   public CreateEventResponseDTO getEventById(UUID eventId){
        Event event = eventRepository.findById(eventId).orElseThrow(()-> new IllegalArgumentException("Event not found with this id: " + eventId));
       return CreateEventResponseDTO.builder()
               .title(event.getTitle())
               .description(event.getDescription())
               .location(event.getLocation())
               .availableTickets(event.getAvailableTickets())
               .pricePerTicket(event.getPricePerTicket())
               .build();
   }


}
