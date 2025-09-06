package moot.queue_management_system.controllers;

import moot.queue_management_system.dtos.TicketDTO;
import moot.queue_management_system.mappers.TicketMapper;
import moot.queue_management_system.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketMapper ticketMapper;

//    @PostMapping
//    public ResponseEntity<TicketDTO> createTicket (@RequestBody TicketDTO dto){
//        var entity = ticketService.create(ticketMapper.toEntity(dto));
//        return new ResponseEntity<>(ticketMapper.toDTO(entity), HttpStatus.CREATED);
//    }
//
//    @GetMapping ("/{id}")
//    public ResponseEntity<TicketDTO> getTicketById (@PathVariable UUID id){
//        var entity = ticketService.getById(id);
//        return new ResponseEntity<>(ticketMapper.toDTO(entity), HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<TicketDTO>> getAllTickets (){
//        var entities = ticketService.getAll();
//        return new ResponseEntity<>(ticketMapper.toDTOs(entities),HttpStatus.OK);
//    }
}
