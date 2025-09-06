package moot.queue_management_system.services;

import moot.queue_management_system.entities.User;
import moot.queue_management_system.exceptions.ResourceNotFoundException;
import moot.queue_management_system.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User create (User user){
        return repository.save(user);
    }

    public User getById (UUID id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(" User with id "+id+" Not found "));
    }

    public List<User> getAll (){
        return repository.findAll();
    }
}
