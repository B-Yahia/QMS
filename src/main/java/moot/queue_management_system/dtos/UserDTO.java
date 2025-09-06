package moot.queue_management_system.dtos;

import lombok.*;
import moot.queue_management_system.entities.UserRole;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class UserDTO {
    private UUID id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private UserRole role;
}
