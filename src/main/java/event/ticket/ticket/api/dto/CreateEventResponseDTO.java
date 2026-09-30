package event.ticket.ticket.api.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEventResponseDTO {
    private String title;
    private String description;
    private String location;
    private BigDecimal pricePerTicket;
    private Integer availableTickets;

}
