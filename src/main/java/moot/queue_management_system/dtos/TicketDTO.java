package moot.queue_management_system.dtos;

import lombok.*;
import moot.queue_management_system.entities.TicketStatus;

import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class TicketDTO {
    private UUID id;
    private UserDTO pedestrian;
    private Integer number;
    private TicketStatus status;
    private boolean priority;
    private String note;
    private UUID queue_id;
    private Integer estimated_wait_seconds;
    private Instant created_at;
    private Instant called_at;
    private Instant service_started_at;
    private Instant completed_at;
    private Instant canceled_at;
    private Instant no_show_at;
    private UUID current_serving_agent_id;
}
