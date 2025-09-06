package moot.queue_management_system.dtos;

import java.util.UUID;

public record CreateTicketRequest(UUID pedestrianId,  // omit if taken from auth
                                  boolean priority,
                                  String note) {
}
