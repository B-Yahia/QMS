package moot.queue_management_system.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class OrganizationDTO {
    private UUID id;
    @NotBlank
    private String name;
    private String description;
    private List<QueueDTO> queues = new ArrayList<>();
}
