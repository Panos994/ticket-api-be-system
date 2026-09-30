package event.ticket.ticket.api.dto;

import event.ticket.ticket.api.entity.Role;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserResponseDTO {
    private UUID userId;
    private String email;
    private Role role;
}
