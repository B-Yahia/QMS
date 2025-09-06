package moot.queue_management_system.controllers;

import moot.queue_management_system.dtos.UserDTO;
import moot.queue_management_system.mappers.UserMapper;
import moot.queue_management_system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper mapper;

    @PostMapping
    public ResponseEntity<UserDTO> createUser (@RequestBody UserDTO dto){
        var entity = userService.create(mapper.toEntity(dto));
        return new ResponseEntity<>(mapper.toDTO(entity), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById (@PathVariable UUID id){
        var entity = userService.getById(id);
        return new ResponseEntity<>(mapper.toDTO(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers (){
        var entities = userService.getAll();
        return new ResponseEntity<>(mapper .toDTOs(entities),HttpStatus.OK);
    }
}
