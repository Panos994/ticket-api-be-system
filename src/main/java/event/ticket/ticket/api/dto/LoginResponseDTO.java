package event.ticket.ticket.api.dto;

import event.ticket.ticket.api.entity.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDTO {
    private String token;
    private Role role;

}
