package event.ticket.ticket.api.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiErrorDTO {
    private String error;
    private String message;
    private int status;
    private LocalDateTime timestamp;
    private String path;
}
