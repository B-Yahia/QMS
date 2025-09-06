package moot.queue_management_system.mappers;

import moot.queue_management_system.dtos.UserDTO;
import moot.queue_management_system.entities.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDTO toDTO(User user) {
        if (user == null) return null;
        return UserDTO.builder()
                .id(user.getId())
                .role(user.getRole())
                .password(user.getPassword())
                .last_name(user.getLast_name())
                .first_name(user.getFirst_name())
                .email(user.getEmail())
                .build();
    }

    public User toEntity(UserDTO dto) {
        if (dto == null) return null;
        return User.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .first_name(dto.getFirst_name())
                .last_name(dto.getLast_name())
                .role(dto.getRole())
                .build();
    }

    // Map a list of User entities to a list of UserDTOs
    public List<UserDTO> toDTOs(List<User> users) {
        if (users == null || users.isEmpty()) return Collections.emptyList();
        return users.stream()
                .filter(Objects::nonNull)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Map a list of UserDTOs to a list of User entities
    public List<User> toEntities(List<UserDTO> dtos) {
        if (dtos == null || dtos.isEmpty()) return Collections.emptyList();
        return dtos.stream()
                .filter(Objects::nonNull)
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
