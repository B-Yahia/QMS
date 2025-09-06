package moot.queue_management_system.services;

import moot.queue_management_system.dtos.CreateTicketRequest;
import moot.queue_management_system.entities.Ticket;
import moot.queue_management_system.entities.TicketStatus;
import moot.queue_management_system.exceptions.ResourceNotFoundException;
import moot.queue_management_system.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;
    @Autowired
    private QueueService queueService;
    @Autowired
    private UserService userService;

    public Ticket create (CreateTicketRequest request , UUID queueId){
        var queue = queueService.getById(queueId);
        var pedestrian = userService.getById(request.pedestrianId());
        // The logic for the order number is stile missing.
        var ticket = Ticket.builder().pedestrian(pedestrian).queue(queue).number(0).status(TicketStatus.WAITING).priority(false).note("")
                .estimated_wait_seconds(1).build();
        return repository.save(ticket);
    }

    public Ticket getById (UUID id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(" Ticket with id "+id+" Not found "));
    }

    public List<Ticket> getAll (){
        return repository.findAll();
    }
}
