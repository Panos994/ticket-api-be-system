package event.ticket.ticket.api.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateReservationResponseDTO {

    private String customerEmail;
    private Integer ticketCount;
    private BigDecimal totalPrice;
    private UUID eventId;
    private LocalDateTime createdAt;
}


