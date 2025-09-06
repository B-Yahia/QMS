package moot.queue_management_system.repositories;

import moot.queue_management_system.entities.Ticket;
import moot.queue_management_system.entities.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    List<Ticket> findByQueueId(UUID queueId);
    List<Ticket> findByPedestrianId(UUID userId);
    List<Ticket> findByStatus(TicketStatus status);
    long countByQueueIdAndStatus(UUID queueId, TicketStatus status);

    @Query("select t from Ticket t where t.queue.id = :queueId and t.created_at between :start and :end")
    List<Ticket> findByQueueIdAndCreatedAtBetween(@Param("queueId") UUID queueId,
                                                  @Param("start") Instant start,
                                                  @Param("end") Instant end);
}
