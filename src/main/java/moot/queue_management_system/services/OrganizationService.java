package moot.queue_management_system.services;

import jakarta.transaction.Transactional;
import moot.queue_management_system.entities.Organization;
import moot.queue_management_system.exceptions.ResourceNotFoundException;
import moot.queue_management_system.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository repository;


    @Transactional
    public Organization create ( Organization organization ){
        return repository.save(organization);
    }

    public Organization getById (UUID id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(" Organization with id "+id+"Not found "));
    }

    public List<Organization> getAll (){
        return repository.findAll();
    }
}
