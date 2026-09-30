package event.ticket.ticket.api.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateReservationRequestDTO {

    private String customerName;
    private String customerEmail;
    private Integer ticketCount;
    private UUID eventId;
}
