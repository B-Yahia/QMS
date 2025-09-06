package moot.queue_management_system.controllers;

import moot.queue_management_system.dtos.OrganizationDTO;
import moot.queue_management_system.mappers.OrganizationMapper;
import moot.queue_management_system.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private OrganizationMapper organizationMapper;

    @PostMapping
    public ResponseEntity<OrganizationDTO> createOrganization (@RequestBody OrganizationDTO dto){
        var org = organizationService.create(organizationMapper.toEntity(dto));
        return new ResponseEntity<>(organizationMapper.toDTO(org), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrganizationDTO>> getAllOrganizations (){
        return new ResponseEntity<>(organizationMapper.toDTOs(organizationService.getAll()),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDTO> getOrganizationById ( @PathVariable UUID id ){
        var org = organizationService.getById(id);
        return new ResponseEntity<>(organizationMapper.toDTO(org), HttpStatus.OK);
    }
}
