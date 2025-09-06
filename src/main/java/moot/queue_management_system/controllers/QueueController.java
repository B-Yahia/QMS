package moot.queue_management_system.controllers;

import moot.queue_management_system.dtos.QueueDTO;
import moot.queue_management_system.dtos.CreateTicketRequest;
import moot.queue_management_system.dtos.TicketDTO;
import moot.queue_management_system.mappers.QueueMapper;
import moot.queue_management_system.mappers.TicketMapper;
import moot.queue_management_system.services.QueueService;
import moot.queue_management_system.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/queue")
public class QueueController {
    @Autowired
    private QueueService queueService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private QueueMapper queueMapper;
    @Autowired
    private TicketMapper ticketMapper;

    @PostMapping
    public ResponseEntity<QueueDTO> createQueue (@RequestBody QueueDTO dto){
        var entity = queueService.create(queueMapper.toEntity(dto));
        return new ResponseEntity<>(queueMapper.toDTO(entity), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/tickets")
    public ResponseEntity<TicketDTO> addticketInQueue (@RequestBody CreateTicketRequest ticketRequest, @PathVariable UUID id){
        var entity = ticketService.create(ticketRequest,id);
        return new ResponseEntity<>(ticketMapper.toDTO(entity), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QueueDTO> getQueueById (@PathVariable UUID id){
        var entity = queueService.getById(id);
        return new ResponseEntity<>(queueMapper.toDTO(entity), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<QueueDTO>> getAllQueues (){
        return  new ResponseEntity<>(queueMapper.toDTOs(queueService.getAll()), HttpStatus.OK);
    }
}
