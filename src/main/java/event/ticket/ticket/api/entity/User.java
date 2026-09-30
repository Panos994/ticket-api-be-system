package event.ticket.ticket.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    @Email
    @NotBlank
    private String email;


    @Column(unique = true)
    @NotBlank
    private String password;

    @Column
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @PrePersist
    public void onCreate(){
        createdAt = LocalDateTime.now();
    }
}
