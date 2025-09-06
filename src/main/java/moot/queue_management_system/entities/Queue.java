package moot.queue_management_system.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Queues")
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    private QueueStatus status;

    @OneToMany(mappedBy = "queue", cascade =CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "organization_id")
    private Organization organization;

    private String description;
    private Integer max_capacity;
    private boolean limited;
    private boolean allow_guest;
    private Instant created_at;
    private Instant updated_at;
}

