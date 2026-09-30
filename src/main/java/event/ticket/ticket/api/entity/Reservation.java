package event.ticket.ticket.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String customerName;

    @Column
    private String customerEmail;

    @Column
    private Integer ticketCount;

    @Column
    private BigDecimal totalPrice;

    @Column
    private LocalDateTime createdAt;

    
    @ManyToOne(fetch = FetchType.LAZY)
    private Event  event;


    @PrePersist
    public void onCreate(){
        createdAt = LocalDateTime.now();
    }
}
