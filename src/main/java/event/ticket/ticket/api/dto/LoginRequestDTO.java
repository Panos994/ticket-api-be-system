package event.ticket.ticket.api.dto;

import io.a2a.util.NotNull;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDTO {
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
}
