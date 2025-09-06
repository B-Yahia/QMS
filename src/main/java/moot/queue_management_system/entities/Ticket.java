package moot.queue_management_system.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Tickets")
public class Ticket {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "pedestrian_id",nullable = false)
    private User pedestrian;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "queue_id",nullable = false)
    private Queue queue;


    @Column(nullable = false)
    private int number;

    @Enumerated(value = EnumType.STRING)
    private TicketStatus status;

    private boolean priority;
    private String note;
    private Integer estimated_wait_seconds;

    //Service time tracking
    private Instant created_at;
    private Instant called_at;
    private Instant service_started_at;
    private Instant completed_at;
    private Instant canceled_at;
    private Instant no_show_at;
    private UUID current_agent_id;

}
