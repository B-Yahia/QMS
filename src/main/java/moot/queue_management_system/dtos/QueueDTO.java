package moot.queue_management_system.dtos;

import lombok.*;
import moot.queue_management_system.entities.QueueStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class QueueDTO {

    private UUID id;
    private String name;
    private QueueStatus status;
    private List<TicketDTO> tickets = new ArrayList<>();
    private String description;
    private Integer max_capacity;
    private boolean limited;
    private boolean allow_guest;
    private UUID organizationId;

}
