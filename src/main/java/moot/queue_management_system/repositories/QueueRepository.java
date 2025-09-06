package moot.queue_management_system.repositories;

import moot.queue_management_system.entities.Queue;
import moot.queue_management_system.entities.QueueStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QueueRepository extends JpaRepository<Queue, UUID> {
    List<Queue> findByOrganizationId(UUID organizationId);
    List<Queue> findByStatus(QueueStatus status);
    long countByOrganizationId(UUID organizationId);
}

