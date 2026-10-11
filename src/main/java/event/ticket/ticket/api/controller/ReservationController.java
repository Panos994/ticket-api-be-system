package event.ticket.ticket.api.controller;

import event.ticket.ticket.api.dto.CreateReservationRequestDTO;
import event.ticket.ticket.api.dto.CreateReservationResponseDTO;
import event.ticket.ticket.api.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<CreateReservationResponseDTO> createReservation(@RequestBody CreateReservationRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.createReservation(dto));
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> cancelReservation(@PathVariable UUID reservationId){
        reservationService.cancelReservation(reservationId);
        return ResponseEntity.ok().build();
    }
}
