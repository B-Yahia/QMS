package moot.queue_management_system.entities;

/**
 * Represents the current status of a ticket in the queue lifecycle.
 */
public enum TicketStatus {
    WAITING,
    CALLED,
    SERVING,
    COMPLETED,
    NO_SHOW,
    CANCELED
}

