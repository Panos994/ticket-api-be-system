package event.ticket.ticket.api.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEventRequestDTO {
    private String title;
    private String description;
    private String location;
    private BigDecimal pricePerTicket;
    private Integer totalTickets;
    private LocalDateTime eventDate;
}
