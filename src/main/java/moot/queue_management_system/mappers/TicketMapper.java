package moot.queue_management_system.mappers;

import moot.queue_management_system.dtos.TicketDTO;
import moot.queue_management_system.entities.Ticket;
import moot.queue_management_system.services.QueueService;
import moot.queue_management_system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TicketMapper {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private QueueService queueService;

    public TicketDTO toDTO(Ticket ticket) {
        if (ticket == null) return null;
        return TicketDTO.builder()
                .id(ticket.getId())
                .pedestrian(userMapper.toDTO(ticket.getPedestrian()))
                .number(ticket.getNumber())
                .status(ticket.getStatus())
                .priority(ticket.isPriority())
                .note(ticket.getNote())
                .estimated_wait_seconds(ticket.getEstimated_wait_seconds())
                .created_at(ticket.getCreated_at())
                .called_at(ticket.getCalled_at())
                .service_started_at(ticket.getService_started_at())
                .completed_at(ticket.getCompleted_at())
                .canceled_at(ticket.getCanceled_at())
                .no_show_at(ticket.getNo_show_at())
                .current_serving_agent_id(ticket.getCurrent_agent_id())
                .build();
    }

    public Ticket toEntity(TicketDTO dto) {
        if (dto == null) return null;
        return Ticket.builder()
                .id(dto.getId())
                .pedestrian(userMapper.toEntity(dto.getPedestrian()))
                .number(dto.getNumber() == null ? 0 : dto.getNumber())
                .status(dto.getStatus())
                .priority(dto.isPriority())
                .note(dto.getNote())
                .estimated_wait_seconds(dto.getEstimated_wait_seconds())
                .created_at(dto.getCreated_at())
                .called_at(dto.getCalled_at())
                .service_started_at(dto.getService_started_at())
                .completed_at(dto.getCompleted_at())
                .canceled_at(dto.getCanceled_at())
                .no_show_at(dto.getNo_show_at())
                .current_agent_id(dto.getCurrent_serving_agent_id())
                .build();
    }

    public List<TicketDTO> toDTOs(List<Ticket> tickets) {
        if (tickets == null || tickets.isEmpty()) return Collections.emptyList();
        return tickets.stream().filter(Objects::nonNull).map(this::toDTO).collect(Collectors.toList());
    }
    public List<Ticket> toEntities(List<TicketDTO> dtos) {
        if (dtos == null || dtos.isEmpty()) return Collections.emptyList();
        return dtos.stream().filter(Objects::nonNull).map(this::toEntity).collect(Collectors.toList());
    }
}
