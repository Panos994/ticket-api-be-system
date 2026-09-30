package event.ticket.ticket.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String title;
    @Column
    private String description;

    @Column
    private String location;
    @Column
    private LocalDateTime eventDate;

    @Column
    private Integer totalTickets;

    @Column
    private Integer availableTickets;

    @Column
    private BigDecimal pricePerTicket;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reservation> reservations;




}
