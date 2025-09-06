package moot.queue_management_system.mappers;

import moot.queue_management_system.dtos.QueueDTO;
import moot.queue_management_system.entities.Queue;
import moot.queue_management_system.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class QueueMapper {
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private OrganizationService organizationService;

    public QueueDTO toDTO(Queue queue) {
        if (queue == null) return null;
        return QueueDTO.builder()
                .id(queue.getId())
                .name(queue.getName())
                .status(queue.getStatus())
                .tickets(ticketMapper.toDTOs(queue.getTickets()))
                .description(queue.getDescription())
                .max_capacity(queue.getMax_capacity())
                .limited(queue.isLimited())
                .allow_guest(queue.isAllow_guest())
                .organizationId(queue.getOrganization().getId())
                .build();
    }

    public Queue toEntity(QueueDTO dto) {
        if (dto == null) return null;
        var org = organizationService.getById(dto.getOrganizationId());
        Queue queue = Queue.builder()
                .id(dto.getId())
                .name(dto.getName())
                .status(dto.getStatus())
                .description(dto.getDescription())
                .max_capacity(dto.getMax_capacity())
                .limited(dto.isLimited())
                .allow_guest(dto.isAllow_guest())
                .organization(org)
                .build();
        if (dto.getTickets() != null && !dto.getTickets().isEmpty()) {
            queue.setTickets(ticketMapper.toEntities(dto.getTickets()));
        }
        return queue;
    }

    public List<QueueDTO> toDTOs(List<Queue> queues) {
        if (queues == null || queues.isEmpty()) return Collections.emptyList();
        return queues.stream().filter(Objects::nonNull).map(this::toDTO).collect(Collectors.toList());
    }

    public List<Queue> toEntities(List<QueueDTO> dtos) {
        if (dtos == null || dtos.isEmpty()) return Collections.emptyList();
        return dtos.stream().filter(Objects::nonNull).map(this::toEntity).collect(Collectors.toList());
    }
}
