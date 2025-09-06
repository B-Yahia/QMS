package moot.queue_management_system.services;

import moot.queue_management_system.dtos.CreateTicketRequest;
import moot.queue_management_system.entities.Queue;
import moot.queue_management_system.exceptions.ResourceNotFoundException;
import moot.queue_management_system.repositories.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class QueueService {

    @Autowired
    private QueueRepository repository;

    public Queue create (Queue queue){
        return repository.save(queue);
    }

    public Queue getById (UUID id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(" Queue with id "+id+" Not found "));
    }

    public List<Queue> getAll (){
        return repository.findAll();
    }

}
