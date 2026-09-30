package event.ticket.ticket.api.controller;

import event.ticket.ticket.api.dto.CreateEventRequestDTO;
import event.ticket.ticket.api.dto.CreateEventResponseDTO;
import event.ticket.ticket.api.entity.Event;
import event.ticket.ticket.api.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<CreateEventResponseDTO> createEvent(@RequestBody @Valid CreateEventRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.createEvent(dto));
    }

    @GetMapping
    public ResponseEntity<List<CreateEventResponseDTO>> getAllEvents(){
        return ResponseEntity.status(HttpStatus.OK).body(eventService.getAllEvents());
    }

    @GetMapping("{eventId}")
    public ResponseEntity<CreateEventResponseDTO> getEvent(@PathVariable UUID eventId){
        return ResponseEntity.status(HttpStatus.OK).body(eventService.getEventById(eventId));
    }
}
